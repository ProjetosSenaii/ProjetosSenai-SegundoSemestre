package com.senai.infob.rental.exceptions;

/** Lançada ao tentar baixar a imagem (GET /produtos/{id}/imagem) de um produto que não tem imagem cadastrada. Vira HTTP 404. */
public class MovimentacaoNotFoundException extends RuntimeException {

    public MovimentacaoNotFoundException(Long movimentacaoId) {
        super("A movimentação com o " + movimentacaoId + " não está cadastrada no sistema.");
    }
}
