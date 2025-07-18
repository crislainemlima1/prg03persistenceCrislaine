/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.ifba.curso.service.ICursoService;

/**
 *
 * @author crisl
 */

@Component
public class CursoController {


    @Autowired
    private ICursoService service;

    public void salvarCurso(Curso curso) {
        service.salvarCurso(curso);
    }

    public void atualizarCurso(Curso curso) {
        service.atualizarCurso(curso);
    }

    public void excluirCurso(Curso curso) {
        service.excluirCurso(curso);
    }

    public Curso buscarPorId(Long id) {
        return service.buscarPorId(id);
    }

    public List<Curso> listarTodos() {
        return service.listarTodos();
    }


}

