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

import com.senai.infob.rental.models.Equipamento;
import com.senai.infob.rental.services.EquipamentoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag (name = "Equipamentos", description = "Operações de cadastro e consulta de equipamentos")
@RestController 
@RequestMapping ("/equipamentos")
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }

    @Operation (summary = "Cadastrar uma nova equipamento")
    @ApiResponses ({
            @ApiResponse (responseCode = "201", description = "Equipamento cadastrada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping 
    public ResponseEntity<Equipamento> salvar(@Valid @RequestBody Equipamento equipamento) {
        Equipamento salva = equipamentoService.salvar(equipamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }

    @Operation(summary = "Listar todas as equipamentos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de equipamentos retornada com sucesso")
    })
    @GetMapping 
    public ResponseEntity<List<Equipamento>> listarTodos() {
        return ResponseEntity.ok(equipamentoService.listarTodos());
    }

    @Operation(summary = "Buscar um equipamento pelo id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Equipamento encontrado"),
            @ApiResponse(responseCode = "404", description = "Equipamento não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Equipamento> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(equipamentoService.buscarPorId(id));
    }

    @Operation(summary = "Atualizar uma equipamento existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Equipamento atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Equipamento não encontrada")
    })
    @PutMapping ("/{id}")
    public ResponseEntity<Equipamento> atualizar(@PathVariable Long id, @Valid @RequestBody Equipamento equipamento) {
        return ResponseEntity.ok(equipamentoService.atualizar(id, equipamento));
    }

    @Operation(summary = "Remover uma equipamento")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Equipamento removida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Equipamento não encontrada")
    })
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        equipamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}