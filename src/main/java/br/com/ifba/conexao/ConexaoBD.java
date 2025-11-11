/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.conexao;

import br.com.ifba.dao.CursoDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author crisl
 */
public class ConexaoBD {

    public class ConexaoDB {
    private static final String URL = "jdbc:mysql://localhost:3306/sistemacurso";
    private static final String USUARIO = "root";
    private static final String SENHA = "123456";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}

}
