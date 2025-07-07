/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.service;

import br.com.ifba.curso.dao.CursolDAO;
import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.util.StringUtil;
import java.util.List;

/**
 *
 * @author crisl
 */
public class CursoService {

    
    private final CursolDAO dao = new CursolDAO();
    
    // salvar curso apos a validaçao de dados obrigatorios
    public void salvarCurso(Curso curso){
        if(StringUtil.isNullOrEmpty(curso.getNome()) || !StringUtil.minimoCaracter(curso.getNome(), 3)){
         throw new RuntimeException("nome invalido"); 
        }  
        if (StringUtil.isNullOrEmpty(curso.getDescricao())) {
            throw new RuntimeException("des ricao obtigatorio");
        }

        if (StringUtil.isNullOrEmpty(curso.getPlataforma())) {
            throw new RuntimeException("plataforma obrigatoria");
        }

        if (!StringUtil.duracaoValida(curso.getDuracao())) {
            throw new RuntimeException("duraçao invalida");
        }

        dao.salvar(curso);
    
        
}
       // todos os tramites de atualizar, buscar por ID, excluir um curso e etc..
     public void atualizarCurso(Curso curso){
         dao.atualizar(curso);
     }
     public void excluirCurso(Curso curso){
         dao.excluir(curso);
     }
     public Curso buscarPorId(Long id){
         return dao.buscarPorId(id);
     }
     public List<Curso> listarTodos(){
         return dao.listarTodos();
     }
}
