package com.rafaelmaschietto.ecotrack.controller;

import com.rafaelmaschietto.ecotrack.model.Categoria;
import com.rafaelmaschietto.ecotrack.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin("*")
@Tag(name = "Categorias", description = "Gerenciamento das categorias de produtos")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @Operation(summary = "Listar categorias", description = "Retorna todas as categorias cadastradas no sistema")
    @GetMapping
    public List<Categoria> listar() {
        return service.listar();
    }

    @Operation(summary = "Criar categoria", description = "Cadastra uma nova categoria")
    @ApiResponse(responseCode = "201", description = "Categoria criada com sucesso")
    @PostMapping
    public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria) {
        Categoria novaCategoria = service.salvar(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria);
    }

    @Operation(summary = "Excluir categoria", description = "Remove uma categoria por ID")
    @ApiResponse(responseCode = "204", description = "Categoria excluída com sucesso")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}