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
import java.util.List;

public interface CursoDAO {
  
     void salvar(Curso curso); // salvar um novo curso no banco de dados
    void atualizar(Curso curso); // atualizar um curso ja existente
    void excluir(Curso curso); // excluir um curso do banco de dados
    Curso buscarPorId(Long id); // buscar o curso pelo ID
    List<Curso> listarTodos(); // retorna uma lista com todos os cursos cadastrados
}
