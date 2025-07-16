/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.curso.dao;

/**
 *
 * @author crisl
 */

import br.com.ifba.curso.entity.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class CursolDAO implements CursoDAO {
    
    // cria a fabrica que fornece a conexao com o banco
    
        @PersistenceContext
    private EntityManager em;

    public void salvar(Curso curso) {
        em.persist(curso);
        System.out.println("Curso salvo: " + curso.getNome());
    }

    public Curso buscarPorId(Long id) {
        return em.find(Curso.class, id);
    }

    public List<Curso> listarTodos() {
        return em.createQuery("FROM Curso", Curso.class).getResultList();
    }

    public void atualizar(Curso curso) {
        em.merge(curso);
    }

    public void excluir(Curso curso) {
        Curso cursoExcluir = em.find(Curso.class, curso.getId());
        if (cursoExcluir != null) {
            em.remove(cursoExcluir);
        }
    }
}



