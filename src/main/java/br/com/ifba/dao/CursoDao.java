package br.com.ifba.dao;

import br.com.ifba.entity.Curso;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CursoDao {

    private final EntityManagerFactory emf;

    public CursoDao() {
        emf = Persistence.createEntityManagerFactory("cursoPU"); 
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Salva um novo curso no banco de dados.
     * Inicia uma transação, persiste o objeto e confirma a transação.
     */

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

    /**
     * Atualiza um curso existente no banco de dados.
     * Usa o método merge para aplicar as alterações e confirma a transação.
     */

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
/**
     * Exclui um curso do banco de dados.
     * Primeiro busca o curso pelo ID, depois remove se existir.
     */

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

    /**
     * Busca um curso no banco de dados pelo seu ID.
     * Retorna o objeto Curso correspondente ou null se não encontrar.
     */

    public Curso buscarPorId(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Curso.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Retorna uma lista com todos os cursos cadastrados no banco.
     * Executa uma consulta JPQL simples.
     */

    public List<Curso> listarTodos() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Curso c", Curso.class).getResultList();
        } finally {
            em.close();
        }
    }
}
