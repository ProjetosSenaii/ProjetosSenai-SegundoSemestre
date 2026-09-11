package com.senai.infob.rental.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.infob.rental.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findById(Long id);

    void deleteById(Long id);

    Optional<Usuario> findByEmail(String email);
    
}
