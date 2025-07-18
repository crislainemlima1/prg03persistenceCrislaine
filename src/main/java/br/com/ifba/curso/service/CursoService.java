/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;


import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.repository.CursoRepository;
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

     // salvar curso apos a validaçao de dados obrigatorios
 @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void salvarCurso(Curso curso) {
        if (StringUtil.isNullOrEmpty(curso.getNome()) || !StringUtil.minimoCaracter(curso.getNome(), 3)) {
            throw new RuntimeException("nome inválido");
        }
        if (StringUtil.isNullOrEmpty(curso.getDescricao())) {
            throw new RuntimeException("descrição obrigatória");
        }
        if (StringUtil.isNullOrEmpty(curso.getPlataforma())) {
            throw new RuntimeException("plataforma obrigatória");
        }
        if (!StringUtil.duracaoValida(curso.getDuracao())) {
            throw new RuntimeException("duração inválida");
        }

        cursoRepository.save(curso);
    }

    @Override
    public void atualizarCurso(Curso curso) {
        cursoRepository.save(curso); // serve pra atualizar também
    }

    @Override
    public void excluirCurso(Curso curso) {
        cursoRepository.delete(curso);
    }

    @Override
    public Curso buscarPorId(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Curso> listarTodos() {
        return cursoRepository.findAll();
    }
}

