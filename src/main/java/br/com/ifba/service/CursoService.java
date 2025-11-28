/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.service;


import br.com.ifba.entity.Curso;
import br.com.ifba.repository.CursoRepository;
import br.com.ifba.util.StringUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author crisl
 */
@Service
public class CursoService implements ICursoService{
    
    @Autowired
    private CursoRepository repository;

    
    // salva o curso no banco com validação para ver se esta preenchido
     @Override
    public void salvarCurso(Curso curso) {
        if (StringUtil.isEmpty(curso.getNome())) {
            throw new IllegalArgumentException("Nome do curso nao pode ser vazio.");
        }
       repository.save(curso);
    }

    // atualiza os dados do curso no banco
    @Override
    public void atualizarCurso(Curso curso) {
       repository.save(curso);
    }

    // exclui o curso do banco
    @Override
    public void excluirCurso(Curso curso) {
        repository.delete(curso);
    }

    // retorna a lista de todos os cursos cadstrado
    @Override
    public List<Curso> listarCursos() {
        return repository.findAll();
    }

    // busca por ID
    @Override
    public Curso buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Curso> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }
    
    public List<Curso> buscarPorPlataforma(String plataforma) {
        return repository.findByNomeContainingIgnoreCase(plataforma);
    }
    
}
