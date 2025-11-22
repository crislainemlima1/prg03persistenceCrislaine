/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.service;

import br.com.ifba.dao.CursoDao;
import br.com.ifba.entity.Curso;
import br.com.ifba.util.StringUtil;
import java.util.List;

/**
 *
 * @author crisl
 */
public class CursoService implements ICursoService{
    
    private final CursoDao dao = new CursoDao();
    
    // salva o curso no banco com validação para ver se esta preenchido
     @Override
    public void salvarCurso(Curso curso) {
        if (StringUtil.isEmpty(curso.getNome())) {
            throw new IllegalArgumentException("Nome do curso nao pode ser vazio.");
        }
        dao.salvar(curso);
    }

    // atualiza os dados do curso no banco
    @Override
    public void atualizarCurso(Curso curso) {
        dao.atualizar(curso);
    }

    // exclui o curso do banco
    @Override
    public void excluirCurso(Curso curso) {
        dao.excluir(curso);
    }

    // retorna a lista de todos os cursos cadstrado
    @Override
    public List<Curso> listarCursos() {
        return dao.listarTodos();
    }

    // busca por ID
    @Override
    public Curso buscarPorId(Long id) {
        return dao.buscarPorId(id);
    }

    
}
