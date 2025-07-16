/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.entity.Curso;
import java.util.List;

/**
 *
 * @author crisl
 */
public interface ICursoService {


    void salvarCurso(Curso curso);
    void atualizarCurso(Curso curso);
    void excluirCurso(Curso curso);
    Curso buscarPorId(Long id);
    List<Curso> listarTodos();
}


