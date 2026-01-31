package com.rafaelmaschietto.ecotrack.controller;


import com.rafaelmaschietto.ecotrack.model.Produto;
import com.rafaelmaschietto.ecotrack.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Produto criar(@RequestBody Produto produto) {
        return service.salvar(produto);
    }

    @PutMapping("/{id}/status")
    public Produto atualizarStatus(@PathVariable Long id, @RequestParam String novoStatus) {
        return service.atualizarStatus(id, novoStatus);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
