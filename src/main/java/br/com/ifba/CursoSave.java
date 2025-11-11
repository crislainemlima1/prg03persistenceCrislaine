/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.ifba;

import br.com.ifba.dao.CursoDao;
import br.com.ifba.entity.Curso;

/**
 *
 * @author crisl
 */
public class CursoSave {

    public static void main(String[] args) {
        System.out.println("curso salvo");
        
        CursoDao dao = new CursoDao();

    Curso c = new Curso();
    c.setNome("Teste Curso");
    c.setDuracao(10);
    c.setDescricao("Curso de Teste");
    c.setPlataforma("Online");

    dao.salvar(c);
    System.out.println("Curso salvo com id: " + c.getId());
    }
}
