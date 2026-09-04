package com.senai.infob.rental.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_categoria")
    private Integer idCategoria;
    
    @Column(name="nome")
    private String nome;

    @Column(name="descricao")
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private java.util.List<Equipamento> equipamentos;

    public Categoria() {
    }

    public Categoria(Integer idCategoria, String nome, String descricao, List<Equipamento> equipamentos) {
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.descricao = descricao;
        this.equipamentos = equipamentos;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public java.util.List<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(java.util.List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

    
}
