package com.senai.infob.rental.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senai.infob.rental.models.Movimentacao;
import com.senai.infob.rental.repositories.MovimentacaoRepository;

@Service 
public class MovimentacaoService {

    private final MovimentacaoRepository movimentacaoRepository;

    public MovimentacaoService(MovimentacaoRepository movimentacaoRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
    }

    public List<Movimentacao> listarTodas() {
        return movimentacaoRepository.findAll();
    }

    public Movimentacao buscarPorId(Long id) {
        return movimentacaoRepository.findById(id)
                .orElseThrow(() -> new MovimentacaoNotFoundException(id));
    }

    public Movimentacao salvar(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

    public Movimentacao atualizar(Long id, Movimentacao movimentacaoAtualizada) {
        Movimentacao movimentacao = buscarPorId(id);
        movimentacao.setDataMovimentacao(movimentacaoAtualizada.getDataMovimentacao());
        movimentacao.setTipoMovimentacao(movimentacaoAtualizada.getTipoMovimentacao());
        movimentacao.setUsuario(movimentacaoAtualizada.getUsuario());
        movimentacao.setQuantidade(movimentacaoAtualizada.getQuantidade());
        return movimentacaoRepository.save(movimentacao);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        movimentacaoRepository.deleteById(id);
    }
}

