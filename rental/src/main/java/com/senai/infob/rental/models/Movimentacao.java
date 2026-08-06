package com.senai.infob.rental.models;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="movimentacao")
public class Movimentacao {
    @Id
    @Column(name="id_movimentacao")
    private Integer idMovimentacao;

    @Column(name="data_movimentacao")
    private Timestamp dataMovimentacao;
}
