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
import br.com.ifba.infrastructure.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CursolDAO implements CursoDAO {
    
    // cria a fabrica que fornece a conexao com o banco
    
     // pega a conexao com o banco de dados
    private EntityManager getEntityManager() {
    return JPAUtil.getEntityManager();
}

    
    // salvar um novo curso no banco de dados
    public void salvar(Curso curso){
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(curso); // persiste o objeto
            System.out.println("Metodo salvar() chamado: " + curso.getNome());
            em.getTransaction().commit();
            System.out.println("Curso persistido no banco com ID: " + curso.getId());
        }
        catch (Exception e){
            em.getTransaction().rollback(); // desfaz em caso de erro
            e.printStackTrace();   
        }
        finally {
                em.close();
                } 
    }
    
    // busca um curso pelo ID
    public Curso buscarPorId(Long id){
        EntityManager em = getEntityManager();
        try {
            return em.find(Curso.class, id);
        }
        finally {
            em.close();
        }
    }
    
    // retorna todos os cursos cadastrados
    public List<Curso> listarTodos(){
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("FROM Curso", Curso.class).getResultList();
        }
        finally {
            em.close();
        }
    }
    
    // atualiza os dados em um curso ja existente
    public void atualizar(Curso curso){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(curso); // atualiza a entidade 
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }

    // exclui um curso do banco
    @Override
    public void excluir(Curso curso) {
       EntityManager em = getEntityManager();
       try {
           em.getTransaction().begin(); 
           // aqui primeiro ele busca o curso no banco para garantir que esta gerenciado
           Curso cursoExcluir = em.find(Curso.class, curso.getId());
           if (cursoExcluir != null){
               em.remove(cursoExcluir);
           }
           em.getTransaction().commit();
       }
       finally {
           em.close();
       }
    }
}
