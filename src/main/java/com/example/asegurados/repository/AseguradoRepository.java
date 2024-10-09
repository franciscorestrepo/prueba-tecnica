package com.example.asegurados.repository;

import com.example.asegurados.model.Asegurado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AseguradoRepository extends JpaRepository<Asegurado,Long> {
    Asegurado findByNroIdentificacionAndTipoIdentificacion(String nroIdentificacion, Integer tipoIdentificacion);

}
