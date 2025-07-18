/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.ifba;


import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.repository.CursoRepository;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author crisl
 */
@SpringBootApplication

public class CursoSave {

    public static void main(String[] args) {
     
      ApplicationContext context = SpringApplication.run(CursoSave.class, args);
       CursoRepository repository = context.getBean(CursoRepository.class);
       
        
        // Criar novo curso
        Curso curso = new Curso();
        curso.setNome("Spring Boot ");
        curso.setDescricao("Curso completo para iniciantes");
        curso.setPlataforma("Alura");
        curso.setDuracao(20);

        // Salvar
        repository.save(curso);
        System.out.println("Curso salvo com ID: " + curso.getId());

        // Listar todos
        List<Curso> cursos = repository.findAll();
        System.out.println("\n--- Lista de Cursos ---");
        for (Curso c : cursos) {
            System.out.println("ID: " + c.getId() + " | Nome: " + c.getNome());
        }

        // Buscar por nome parcial
        List<Curso> encontrados = repository.findByNomeContainingIgnoreCase("spring");
        System.out.println("\n--- Busca por nome ---");
        for (Curso c : encontrados) {
            System.out.println("Encontrado: " + c.getNome());
        }
    }
}
