/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.service;


import br.com.ifba.entity.Curso;
import br.com.ifba.repository.CursoRepository;
import br.com.ifba.util.StringUtil;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author crisl
 */
@Service
@Slf4j
@RequiredArgsConstructor
@Transactional


public class CursoService implements ICursoService{
    
    @Autowired
    private CursoRepository repository;

     private static final org.slf4j.Logger log = LoggerFactory.getLogger(CursoService.class);
    // salva o curso no banco com validação para ver se esta preenchido
     @Override
     public void salvarCurso(Curso curso) {
        if (StringUtil.isEmpty(curso.getNome())) {
            log.warn("Tentativa de salvar curso com nome vazio");
            throw new IllegalArgumentException("Nome do curso não pode ser vazio.");
        }
        repository.save(curso);
        log.info("Curso salvo com sucesso: {}", curso);
    }


    // atualiza os dados do curso no banco
    @Override
    public void atualizarCurso(Curso curso) {
       repository.save(curso);
       log.info("Curso atualizado: {}", curso);
    }

    // exclui o curso do banco
    @Override
    public void excluirCurso(Curso curso) {
        repository.delete(curso);
        log.info("Curso excluído: {}", curso);

    }

   // lista todos os cursos
    @Override
    public List<Curso> listarCursos() {
        List<Curso> cursos = repository.findAll();
        log.debug("Listando cursos, total encontrado: {}", cursos.size());
        return cursos;
    }

    // busca por ID
    @Override
    public Curso buscarPorId(Long id) {
        Curso curso = repository.findById(id).orElse(null);
        if (curso == null) {
            log.warn("Curso não encontrado com id: {}", id);
        } else {
            log.info("Curso encontrado: {}", curso);
        }
        return curso;
    }


   public List<Curso> buscarPorNome(String nome) {
        List<Curso> cursos = repository.findByNomeContainingIgnoreCase(nome);
        log.info("Busca por nome '{}', encontrados {} cursos", nome, cursos.size());
        return cursos;
    }

    public List<Curso> buscarPorPlataforma(String plataforma) {
        List<Curso> cursos = repository.findByNomeContainingIgnoreCase(plataforma);
        log.info("Busca por plataforma '{}', encontrados {} cursos", plataforma, cursos.size());
        return cursos;
    }

    
}
