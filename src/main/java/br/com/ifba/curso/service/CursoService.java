/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.dao.CursoDAO;
import br.com.ifba.curso.dao.CursolDAO;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.util.StringUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author crisl
 */
@Service
public class CursoService implements ICursoService {

    
    
    
    @Autowired
    // salvar curso apos a validaçao de dados obrigatorios
    private CursoDAO dao;

    public void salvarCurso(Curso curso) {
        if (StringUtil.isNullOrEmpty(curso.getNome()) || !StringUtil.minimoCaracter(curso.getNome(), 3)) {
            throw new RuntimeException("nome invalido"); 
        }
        if (StringUtil.isNullOrEmpty(curso.getDescricao())) {
            throw new RuntimeException("descricao obrigatória");
        }
        if (StringUtil.isNullOrEmpty(curso.getPlataforma())) {
            throw new RuntimeException("plataforma obrigatória");
        }
        if (!StringUtil.duracaoValida(curso.getDuracao())) {
            throw new RuntimeException("duração invalida");
        }

        dao.salvar(curso);
    }

    public void atualizarCurso(Curso curso) {
        dao.atualizar(curso);
    }

    public void excluirCurso(Curso curso) {
        dao.excluir(curso);
    }

    public Curso buscarPorId(Long id) {
        return dao.buscarPorId(id);
    }

    public List<Curso> listarTodos() {
        return dao.listarTodos();
    }


}
