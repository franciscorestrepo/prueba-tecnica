package com.example.asegurados.repository;

import com.example.asegurados.model.Prima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PrimaRepository extends JpaRepository<Prima,Long> {

}
