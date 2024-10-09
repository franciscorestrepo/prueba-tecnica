package com.example.asegurados.service;

import com.example.asegurados.dto.AseguradoDTO;
import com.example.asegurados.dto.LiquidacionDTO;
import com.example.asegurados.model.Amparo;
import com.example.asegurados.model.Asegurado;
import com.example.asegurados.model.Prima;
import com.example.asegurados.repository.AmparoRepository;
import com.example.asegurados.repository.AseguradoRepository;
import com.example.asegurados.repository.PrimaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@Service
public class LiquidacionService {

    @Autowired
    private AseguradoRepository aseguradoRepository;

    @Autowired
    private AmparoRepository amparoRepository;

    @Autowired
    private PrimaRepository primaRepository;

    public LiquidacionDTO calcularLiquidacion(AseguradoDTO aseguradoDTO) {

        if (aseguradoDTO.getNroIdentificacion() == null || aseguradoDTO.getValorAsegurado() == null) {
            throw new IllegalArgumentException("Todos los datos de entrada (numero_identificacion, valor_asegurado) son obligatorios.");
        }

        if (aseguradoDTO.getTipoIdentificacion() == null ||
                (aseguradoDTO.getTipoIdentificacion() != 1 && aseguradoDTO.getTipoIdentificacion() != 2)) {
            throw new IllegalArgumentException("El tipo de identificación es inválido. Debe ser 1 (CC) o 2 (CE).");
        }


        Asegurado asegurado = aseguradoRepository.findByNroIdentificacionAndTipoIdentificacion(
                aseguradoDTO.getNroIdentificacion(),aseguradoDTO.getTipoIdentificacion());
        if (asegurado == null) {
            throw new IllegalArgumentException("El número de identificación no corresponde a un asegurado registrado.");
        }


        if (aseguradoDTO.getTipoIdentificacion() == null) {
            throw new IllegalArgumentException("El tipo de identificación es obligatorio.");
        }


        if (aseguradoDTO.getValorAsegurado() <= 0) {
            throw new IllegalArgumentException("El valor asegurado debe ser mayor que cero.");
        }

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(asegurado.getFechaNacimiento());
        LocalDate fechaNac = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
        int edad = Period.between(fechaNac, LocalDate.now()).getYears();


        if (edad < 18 || edad > 75) {
         throw new IllegalArgumentException("La edad del asegurado no está cubierta por las primas disponibles (entre 18 y 75 años).");
        }


        List<Amparo> amparos = amparoRepository.findAll();

        List<LiquidacionDTO.AmparoLiquidacion> liquidacion = new ArrayList<>();
        double valorTotal = 0;

        for (Amparo amparo : amparos) {
            Prima primaAplicable = null;


            List<Prima> primas = primaRepository.findAll();
            for (Prima prima : primas) {
                System.out.println("Rango prima: " + prima.getEdadMinima() + " - " + prima.getEdadMaxima());

                if (edad >= prima.getEdadMinima() && edad <= prima.getEdadMaxima()) {
                    primaAplicable = prima;
                    break;
                }
            }

            // Si encontramos una prima aplicable, crear la liquidación del amparo
            if (primaAplicable != null) {
                LiquidacionDTO.AmparoLiquidacion amparoLiquidacion = new LiquidacionDTO.AmparoLiquidacion();
                amparoLiquidacion.setCodigoAmparo(amparo.getCodigo().intValue());
                amparoLiquidacion.setNombreAmparo(amparo.getNombre());
                amparoLiquidacion.setValorPrima(aseguradoDTO.getValorAsegurado() * primaAplicable.getPorcentajePrima());

                valorTotal += amparoLiquidacion.getValorPrima();
                liquidacion.add(amparoLiquidacion);
            }
        }

        LiquidacionDTO liquidacionDTO = new LiquidacionDTO();
        liquidacionDTO.setTipoIdentificacion(aseguradoDTO.getTipoIdentificacion());
        liquidacionDTO.setNroIdentificacion(aseguradoDTO.getNroIdentificacion());
        liquidacionDTO.setValorAsegurado(aseguradoDTO.getValorAsegurado());
        liquidacionDTO.setLiquidacion(liquidacion);
        liquidacionDTO.setValorTotal(valorTotal);

        if (liquidacion.isEmpty()) {
            liquidacionDTO.setLiquidacion(new ArrayList<>());
            liquidacionDTO.setValorTotal(0);
            System.out.println("No se encontraron amparos aplicables para la edad del asegurado.");
        }

        return liquidacionDTO;
    }

}
