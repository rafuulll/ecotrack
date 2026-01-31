package com.rafaelmaschietto.ecotrack.controller;

import com.rafaelmaschietto.ecotrack.model.Produto;
import com.rafaelmaschietto.ecotrack.service.ProdutoService;
import jakarta.validation.Valid; // Importação necessária
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<Produto> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Produto> criar(@Valid @RequestBody Produto produto) {
        Produto novoProduto = service.salvar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Produto> atualizarStatus(@PathVariable Long id, @RequestParam String novoStatus) {
        Produto produtoAtualizado = service.atualizarStatus(id, novoStatus);
        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}