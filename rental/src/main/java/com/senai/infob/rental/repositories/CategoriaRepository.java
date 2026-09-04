package com.senai.infob.rental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.infob.rental.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    Categoria findById(Long id);
    void deleteById(Long id);
}