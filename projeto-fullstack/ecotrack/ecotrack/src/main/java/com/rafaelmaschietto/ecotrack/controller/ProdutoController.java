package com.rafaelmaschietto.ecotrack.controller;

import com.rafaelmaschietto.ecotrack.model.Produto;
import com.rafaelmaschietto.ecotrack.service.ProdutoService;
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
@RequestMapping("/api/produtos")
@CrossOrigin("*")
@Tag(name = "Produtos", description = "Operações de busca, cadastro, alteração e exclusão de produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @Operation(summary = "Listar produtos", description = "Exibe a lista de todos os produtos")
    @GetMapping
    public List<Produto> listar() {
        return service.listarTodos();
    }

    @Operation(summary = "Cadastrar produto", description = "Cadastra um novo produto")
    @ApiResponse(responseCode = "201", description = "Produto salvo com sucesso")
    @PostMapping
    public ResponseEntity<Produto> criar(@Valid @RequestBody Produto produto) {
        Produto novoProduto = service.salvar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    @Operation(summary = "Atualizar status", description = "Altera o status de um produto")
    @PutMapping("/{id}/status")
    public ResponseEntity<Produto> atualizarStatus(@PathVariable Long id, @RequestParam String novoStatus) {
        Produto produtoAtualizado = service.atualizarStatus(id, novoStatus);
        return ResponseEntity.ok(produtoAtualizado);
    }

    @Operation(summary = "Remover produto", description = "Deleta o produto do sistema por ID")
    @ApiResponse(responseCode = "204", description = "Produto removido com sucesso")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}