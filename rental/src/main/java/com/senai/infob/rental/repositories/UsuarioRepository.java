package com.senai.infob.rental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.infob.rental.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
}
