package com.senai.infob.rental.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "equipamento")
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_equipamento")
    private Integer idEquipamento;
    
    @Column(name="marca")
    private String marca;

    @Column(name="modelo")
    private String modelo;

    @Column(name="descricao")
    private String descricao;

    @Column(name="estoque")
    private Integer estoque;

    @Column(name="potencia", nullable = true)
    private Integer potencia;

    @Column(name="material", nullable = true)
    private String material;

    @Column(name="cor", nullable = true)
    private String cor;

    @Column(name="peso")
    private Double peso;

    @Column(name="preco")
    private Double preco;

    @Column(name="dimensoes", nullable = true)
    private String dimensoes;

    @OneToOne(mappedBy = "equipamento")
    private Categoria categoria;

    @Column(name="quantidade_minima")
    private Integer quantidadeMinima;

    public Equipamento() {
    }

    public Equipamento(Integer idEquipamento, String marca, String modelo,
         String descricao, Integer estoque,
         Categoria categoria, Integer potencia, String material,
          String cor, Double peso, String dimensoes, Integer quantidadeMinima,
          Double preco) {
        this.idEquipamento = idEquipamento;
        this.marca = marca;
        this.modelo = modelo;
        this.descricao = descricao;
        this.estoque = estoque;
        this.categoria = categoria;
        this.potencia = potencia;
        this.material = material;
        this.cor = cor;
        this.peso = peso;
        this.dimensoes = dimensoes;
        this.quantidadeMinima = quantidadeMinima;
        this.preco = preco;
    }

    public Integer getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(Integer idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(Integer quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    
    
}
