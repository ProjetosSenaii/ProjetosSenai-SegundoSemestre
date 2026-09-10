package com.senai.infob.rental.exceptions;

/** Lançada quando o id de produto informado (GET/PUT/DELETE /produtos/{id}) não existe. Vira HTTP 404. */
public class EquipamentoNotFoundException extends RuntimeException {

    public EquipamentoNotFoundException(Long id) {
        super("Equipamento não encontrado com id: " + id);
    }
}
