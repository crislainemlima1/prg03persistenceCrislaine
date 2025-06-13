/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author crisl
 */
@Entity
@Table(name = "curso")
public class Curso implements Serializable {
    
    @Id // chave primaria 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //configura como o id sera gerado
    
    private Long id;
    // entidades
    
    private String nome;
    private int quantidade;
    private String descricao;
    private String fornecedor;

    // construtores
    public Curso() {
    }

    public Curso(String nome, int quantidade, String descricao, String fornecedor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
    }  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
   
    public String toString(){
        return "Curso{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", quantidade=" + quantidade +
               ", descricao='" + descricao + '\'' +
               ", fornecedor='" + fornecedor + '\'' +
               '}';
    }
}
