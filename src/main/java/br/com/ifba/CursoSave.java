/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.ifba;

import br.com.ifba.curso.dao.CursoDAO;
import br.com.ifba.curso.dao.CursolDAO;
import br.com.ifba.curso.entity.Curso;
import java.util.List;

/**
 *
 * @author crisl
 */
public class CursoSave {

    public static void main(String[] args) {
      CursoDAO dao = new CursolDAO();

        // criar e salvar novo curso
        Curso novoCurso = new Curso();
        novoCurso.setNome("curso java");
        novoCurso.setDescricao("curso java completo");
        dao.salvar(novoCurso);
        System.out.println("curso salvo com ID: " + novoCurso.getId());

        // listar todos os cursos
        List<Curso> cursos = dao.listarTodos();
        System.out.println("\n-----lista de cursos----");
        for (Curso c : cursos) {
            System.out.println("ID: " + c.getId() + " | nome: " + c.getNome());
        }

        // buscar curso por ID
        Curso curso = dao.buscarPorId(novoCurso.getId());
        if (curso != null) {
            System.out.println("\ncurso encontrado " + curso.getNome());
        }

        // atualizar curso
        curso.setNome("curso java avancado");
        dao.atualizar(curso);
        System.out.println("curso atualizado");

        // excluir curso
        dao.excluir(curso);
        System.out.println("curso excluido");
    }
}
