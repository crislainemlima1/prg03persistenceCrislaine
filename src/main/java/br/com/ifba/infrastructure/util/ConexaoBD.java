/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author crisl
 */
public class ConexaoBD {
  
    private static final String URL = "jdbc:mysql://localhost:3306/bd_curso";
    private static final String USUARIO = "root";
    private static final String SENHA = "123456"; 

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            throw new RuntimeException("erro na conexao do banco" + e.getMessage(), e);
        }
    }

}
