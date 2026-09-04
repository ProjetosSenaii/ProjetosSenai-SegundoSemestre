package com.senai.infob.rental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.infob.rental.models.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer>{
    Movimentacao findById(Long id);
    void deleteById(Long id);
}
