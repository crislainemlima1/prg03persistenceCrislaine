/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.service;

import br.com.ifba.entity.Curso;
import java.util.List;

/**
 *
 * @author crisl
 */

// interface que define o que o serviço curso precisa fazer
public interface ICursoService {
    
    void salvarCurso(Curso curso);
    void atualizarCurso(Curso curso);
    void excluirCurso(Curso curso);
    List<Curso> listarCursos();
    Curso buscarPorId(Long id);


}
