package com.senai.infob.rental.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.senai.infob.rental.models.Equipamento;
import com.senai.infob.rental.repositories.CategoriaRepository;
import com.senai.infob.rental.repositories.EquipamentoRepository;

@Service 
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;

    public EquipamentoService(EquipamentoRepository equipamentoRepository, CategoriaRepository categoriaRepository) {
        this.equipamentoRepository = equipamentoRepository;
    }

    public List<Equipamento> listarTodos() {
        return equipamentoRepository.findAll();
    }

    public Equipamento buscarPorId(Long id) {
        return equipamentoRepository.findById(id)
                .orElseThrow(() -> new EquipamentoNotFoundException(id));
    }

    public Equipamento salvar(Equipamento equipamento) {
        return equipamentoRepository.save(equipamento);
    }

    public Equipamento atualizar(Long id, Equipamento equipamentoAtualizado) {
        Equipamento equipamento = buscarPorId(id);
        equipamento.setDescricao(equipamentoAtualizado.getDescricao());
        equipamento.setPreco(equipamentoAtualizado.getPreco());
        equipamento.setCategoria(equipamentoAtualizado.getCategoria());
        equipamento.setQuantidadeMinima(equipamentoAtualizado.getQuantidadeMinima());
        equipamento.setEstoque(equipamentoAtualizado.getEstoque());
        equipamento.setMarca(equipamentoAtualizado.getMarca());
        equipamento.setModelo(equipamentoAtualizado.getModelo());
        equipamento.setPotencia(equipamentoAtualizado.getPotencia());
        equipamento.setMaterial(equipamentoAtualizado.getMaterial());
        equipamento.setCor(equipamentoAtualizado.getCor());
        equipamento.setPeso(equipamentoAtualizado.getPeso());
        equipamento.setDimensoes(equipamentoAtualizado.getDimensoes());
        return equipamentoRepository.save(equipamento);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        equipamentoRepository.deleteById(id);
    }

    public List<Equipamento> buscarPorCategoria(Long categoriaId) {
        return equipamentoRepository.buscarPorCategoria(categoriaId);
    }

    public List<Equipamento> buscarPorFaixaDePreco(BigDecimal min, BigDecimal max) {
        return equipamentoRepository.buscarPorFaixaDePreco(min, max);
    }
}   

