package br.com.ifba.dao;

import br.com.ifba.entity.Curso;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CursoDao {

    private final EntityManagerFactory emf;

    public CursoDao() {
        emf = Persistence.createEntityManagerFactory("cursoPU"); // deve bater com o nome no persistence.xml
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void salvar(Curso curso) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void atualizar(Curso curso) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void excluir(Curso curso) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Curso cursoParaExcluir = em.find(Curso.class, curso.getId());
            if (cursoParaExcluir != null) {
                em.remove(cursoParaExcluir);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Curso buscarPorId(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Curso.class, id);
        } finally {
            em.close();
        }
    }

    public List<Curso> listarTodos() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Curso c", Curso.class).getResultList();
        } finally {
            em.close();
        }
    }
}
