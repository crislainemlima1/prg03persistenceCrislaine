/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.controller;

import br.com.ifba.entity.Curso;
import br.com.ifba.service.CursoService;
import java.util.List;

/**
 *
 * @author crisl
 */
public class CursoController {
    
     private final CursoService service = new CursoService();

     // classe controller que repassa as açoes pra camada service
    public void salvar(Curso curso) {
        service.salvarCurso(curso);
    }

    public void atualizar(Curso curso) {
        service.atualizarCurso(curso);
    }

    public void excluir(Curso curso) {
        service.excluirCurso(curso);
    }

    public List<Curso> listar() {
        return service.listarCursos();
    }

    public Curso buscarPorId(Long id) {
        return service.buscarPorId(id);
    }

}
