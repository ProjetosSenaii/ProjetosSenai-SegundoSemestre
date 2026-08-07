package com.senai.infob.rental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.infob.rental.models.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer> {

    
}
