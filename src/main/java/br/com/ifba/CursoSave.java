/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.ifba;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.ifba.entity.Curso;
import br.com.ifba.repository.CursoRepository;

/**
 *
 * @author crisl
 */
@Component
public class CursoSave implements CommandLineRunner {

    @Autowired
    private CursoRepository repository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Salvando curso via Spring Boot...");

        Curso c = new Curso();
      //  c.setNome("Teste Curso");
       // c.setDuracao(10);
      //  c.setDescricao("Curso de Teste");
       // c.setPlataforma("Online");

        repository.save(c);

       // System.out.println("Curso salvo com id: " + c.getId());
    }
}
