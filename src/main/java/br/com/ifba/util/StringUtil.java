/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.util;

/**
 *
 * @author crisl
 */

//// Classe utilitária que verifica se um texto está vazio ou nulo
public class StringUtil {
    public static boolean isEmpty(String texto) {
        return texto == null || texto.trim().isEmpty();
    }
}
