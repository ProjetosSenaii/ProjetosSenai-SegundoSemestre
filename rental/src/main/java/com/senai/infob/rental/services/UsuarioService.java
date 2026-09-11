package com.senai.infob.rental.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senai.infob.rental.models.Usuario;
import com.senai.infob.rental.repositories.UsuarioRepository;

@Service 
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
        Usuario usuario = buscarPorId(id);
        usuario.setUsername(usuarioAtualizado.getUsername());
        usuario.setPassword(usuarioAtualizado.getPassword());
        usuario.setRole(usuarioAtualizado.getRole());
        return usuarioRepository.save(usuario);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        usuarioRepository.deleteById(id);
    }

}   