package com.senai.infob.rental.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.senai.infob.rental.models.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer> {
    Equipamento findById(Long id);
    void deleteById(Long id);
    
      @Query("""
            SELECT p
            FROM Produto p
            WHERE p.categoria.id = :categoriaId
            """)
    List<Equipamento> buscarPorCategoria(@Param("categoriaId") Long categoriaId);

    @Query("""
            SELECT p
            FROM Produto p
            WHERE p.preco BETWEEN :min AND :max
            """)
    List<Equipamento> buscarPorFaixaDePreco(
            @Param("min") BigDecimal min,
            @Param("max") BigDecimal max);
}
