package com.senai.infob.rental.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senai.infob.rental.exceptions.CategoriaNotFoundException;
import com.senai.infob.rental.models.Categoria;
import com.senai.infob.rental.repositories.CategoriaRepository;


/** Regras de negócio de categoria: CRUD, lançando {@link CategoriaNotFoundException} quando o id não existe. */
@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new Exception("Não encontrado"));
    }

    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria atualizar(Long id, Categoria categoriaAtualizada) {
        Categoria categoria = buscarPorId(id);
        categoria.setNome(categoriaAtualizada.getNome());
        return categoriaRepository.save(categoria);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        categoriaRepository.deleteById(id);
    }
}
