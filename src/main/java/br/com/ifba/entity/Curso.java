/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.entity;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author crisl
 */
@Entity
@Table(name = "curso")
@Data  // gerar getters e stters e etc..
@NoArgsConstructor // Construtor vazio
@AllArgsConstructor // Construtor com todos os campos
@Builder // Permite criar objetos com padrão builder
@Getter
@Setter

public class Curso implements Serializable {
    
    @Id // chave primaria 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //configura como o id sera gerado
    private Long id;
    // entidades
    
    private String nome;
    private int duracao;
    private String descricao;
    private String plataforma;

}