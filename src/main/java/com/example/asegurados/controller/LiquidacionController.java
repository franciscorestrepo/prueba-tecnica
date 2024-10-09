package com.example.asegurados.controller;

import com.example.asegurados.dto.AseguradoDTO;
import com.example.asegurados.dto.LiquidacionDTO;
import com.example.asegurados.service.LiquidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/liquidacion")
public class LiquidacionController {


    @Autowired
    private LiquidacionService liquidacionService;

    // Endpoint para calcular la liquidación
    @PostMapping("/calcular")
    public ResponseEntity<?> calcularLiquidacion(@RequestBody List<AseguradoDTO> aseguradosDTO) {
        try {
            // Procesar cada AseguradoDTO y calcular la liquidación
            List<LiquidacionDTO> liquidaciones = aseguradosDTO.stream()
                    .map(liquidacionService::calcularLiquidacion)
                    .toList();

            return ResponseEntity.ok(liquidaciones); // Retorna la lista de liquidaciones
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la solicitud.");
        }
    }

 }


