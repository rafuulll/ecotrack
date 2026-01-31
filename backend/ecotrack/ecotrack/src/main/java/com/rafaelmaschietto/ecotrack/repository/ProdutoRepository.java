package com.rafaelmaschietto.ecotrack.repository;

import com.rafaelmaschietto.ecotrack.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
