package com.senai.infob.rental.models;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="movimentacao")
public class Movimentacao {
    @Id
    @Column(name="id_movimentacao")
    private Integer id;

    @Column(name="data_movimentacao")
    private Timestamp dataMovimentacao;

    @Column(name="tipo_movimentacao")
    private String tipoMovimentacao;

    @ManyToOne 
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name="quantidade")
    private Integer quantidade;

    public Movimentacao() {
    }

    public Movimentacao(Integer id, Timestamp dataMovimentacao, String tipoMovimentacao, Usuario usuario, Integer quantidade) {
        this.id = id;
        this.dataMovimentacao = dataMovimentacao;
        this.tipoMovimentacao = tipoMovimentacao;
        this.usuario = usuario;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(Timestamp dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
