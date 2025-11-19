/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author crisl
 * @param <T>
 */

public abstract class GenericDao<T> implements IGenericDao<T> {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoPU");
    private final Class<T> classe;

    // Construtor que recebe a classe da entidade
    public GenericDao(Class<T> classe) {
        this.classe = classe;
    }

     // Cria e retorna o EntityManager pra acessar o banco
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // salva a entidade no banco
    public void salvar(T entidade) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entidade);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // atualiza os dados da entidade no banco
    public void atualizar(T entidade) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entidade);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // remove a entidade do banco
    public void excluir(T entidade) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.contains(entidade) ? entidade : em.merge(entidade));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // busca a entidade pelo ID
    public T buscarPorId(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(classe, id);
        } finally {
            em.close();
        }
    }

    //lista todas as entidades do tipo informada
    public List<T> listarTodos() {
        EntityManager em = getEntityManager();
        try {
            String jpql = "SELECT t FROM " + classe.getSimpleName() + " t";
            return em.createQuery(jpql, classe).getResultList();
        } finally {
            em.close();
        }
    }
}


