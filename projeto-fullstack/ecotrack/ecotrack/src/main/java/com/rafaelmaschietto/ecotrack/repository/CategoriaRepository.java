package com.rafaelmaschietto.ecotrack.repository;

import com.rafaelmaschietto.ecotrack.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
