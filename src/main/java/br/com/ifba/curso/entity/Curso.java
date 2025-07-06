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
    private int duracao;
    private String descricao;
    private String plataforma;

    // construtores
    public Curso() {
    }

    public Curso(Long id, String nome, int duracao, String descricao, String plataforma) {
        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
        this.descricao = descricao;
        this.plataforma = plataforma;
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

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    

    
}
