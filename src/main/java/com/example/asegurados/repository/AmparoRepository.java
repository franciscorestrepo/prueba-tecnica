package com.example.asegurados.repository;

import com.example.asegurados.model.Amparo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AmparoRepository extends JpaRepository<Amparo,Long> {
    @Query("SELECT a FROM Amparo a WHERE a.nombre = :nombre")
    List<Amparo> findByNombre(@Param("nombre") String nombre);

}
