package com.rafaelmaschietto.ecotrack.service;


import com.rafaelmaschietto.ecotrack.model.Produto;
import com.rafaelmaschietto.ecotrack.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public Produto salvar(Produto produto) {
        // Validação de segurança
        if (produto.getPrecoBruto() < 5.00) {
            throw new RuntimeException("O preço deve ser no mínimo R$ 5,00");
        }

        if (produto.getTaxa() == null) {
            produto.setTaxa(20.0);
        }

        double valorRetirado = produto.getPrecoBruto() * (produto.getTaxa() / 100);

        produto.setPrecoLiquido(produto.getPrecoBruto() - valorRetirado);

        if(produto.getStatus() == null) {
            produto.setStatus("CURADORIA");
        }

        return repository.save(produto);
    }

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com id: " + id));
    }

    public Produto atualizarStatus(Long id, String novoStatus) {
        Produto p = buscarPorId(id);
        p.setStatus(novoStatus);
        return repository.save(p);
    }
}
