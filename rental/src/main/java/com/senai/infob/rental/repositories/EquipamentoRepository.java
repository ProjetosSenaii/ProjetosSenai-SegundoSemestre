package com.senai.infob.rental.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.senai.infob.rental.models.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
    @Query("""
            SELECT e
            FROM Equipamento e
            WHERE e.categoria.id = :categoriaId
            """)
    List<Equipamento> buscarPorCategoria(@Param("categoriaId") Long categoriaId);

    @Query("""
            SELECT e
            FROM Equipamento e
            WHERE e.preco BETWEEN :min AND :max
            """)
    List<Equipamento> buscarPorFaixaDePreco(
            @Param("min") BigDecimal min,
            @Param("max") BigDecimal max);
}
