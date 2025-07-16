/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba;


import br.com.ifba.curso.view.CursoLista;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;



/**
 *
 * @author crisl
 */

@SpringBootApplication
public class Prg03StringApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(Prg03StringApplication.class)
            .headless(false)
            .run(args);

        CursoLista tela = context.getBean(CursoLista.class);
        tela.setVisible(true);
    }
}

