package com.rafaelmaschietto.ecotrack.model;

import jakarta.persistence.*;

@Entity
public class Produto {
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double precoBruto;
    private Double taxa;
    private Double precoLiquido;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrecoLiquido() {
        return precoLiquido;
    }

    public void setPrecoLiquido(Double precoLiquido) {
        this.precoLiquido = precoLiquido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getPrecoBruto() {
        return precoBruto;
    }

    public void setPrecoBruto(Double precoBruto) {
        this.precoBruto = precoBruto;
    }

    public Double getTaxa() {
        return taxa;
    }

    public void setTaxa(Double taxa) {
        this.taxa = taxa;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}