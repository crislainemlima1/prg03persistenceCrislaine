/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba;

import br.com.ifba.view.CursoLista;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.SwingUtilities;

@SpringBootApplication
public class Prg03PersistenceApplication {

    public static void main(String[] args) {
      
        SpringApplication.run(Prg03PersistenceApplication.class, args);
        SwingUtilities.invokeLater(() -> {
            new CursoLista().setVisible(true);
        });
    }
}
