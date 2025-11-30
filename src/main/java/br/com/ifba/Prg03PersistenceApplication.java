/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba;

import br.com.ifba.view.CursoLista;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.SwingUtilities;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Prg03PersistenceApplication {

    public static ApplicationContext context;

    public static void main(String[] args) {
      
      // inicializa o Spring Boot e guarda o contexto
        context = SpringApplication.run(Prg03PersistenceApplication.class, args);

        // abre a tela Swing depois que o Spring subir
        javax.swing.SwingUtilities.invokeLater(() -> {
            new CursoLista().setVisible(true);
        });

    }
}
