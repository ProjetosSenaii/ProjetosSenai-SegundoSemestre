package com.senai.infob.rental.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infob.rental.models.Movimentacao;
import com.senai.infob.rental.services.MovimentacaoService;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag (name = "Movimentacaos", description = "Operações de cadastro e consulta de movimentacaos")
@RestController 
@RequestMapping ("/movimentacaos")
public class MovimentacaoController {

    private final MovimentacaoService movimentacaoService;

    public MovimentacaoController(MovimentacaoService movimentacaoService) {
        this.movimentacaoService = movimentacaoService;
    }

    @Operation (summary = "Cadastrar uma nova movimentacao")
    @ApiResponses ({
            @ApiResponse (responseCode = "201", description = "Movimentacao cadastrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping 
    public ResponseEntity<Movimentacao> salvar(@Valid @RequestBody Movimentacao movimentacao) {
        Movimentacao salva = movimentacaoService.salvar(movimentacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    @Operation(summary = "Listar todas as movimentacaos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de movimentacaos retornada com sucesso")
    })
    @GetMapping 
    public ResponseEntity<List<Movimentacao>> listarTodas() {
        return ResponseEntity.ok(movimentacaoService.listarTodas());
    }

    @Operation(summary = "Buscar uma movimentacao pelo id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Movimentacao encontrada"),
            @ApiResponse(responseCode = "404", description = "Movimentacao não encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Movimentacao> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(movimentacaoService.buscarPorId(id));
    }

    @Operation(summary = "Atualizar uma movimentacao existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Movimentacao atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Movimentacao não encontrada")
    })
    @PutMapping ("/{id}")
    public ResponseEntity<Movimentacao> atualizar(@PathVariable Long id, @Valid @RequestBody Movimentacao movimentacao) {
        return ResponseEntity.ok(movimentacaoService.atualizar(id, movimentacao));
    }

    @Operation(summary = "Remover uma movimentacao")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Movimentacao removida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Movimentacao não encontrada")
    })
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        movimentacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}