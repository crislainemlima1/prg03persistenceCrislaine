/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.util;

/**
 *
 * @author crisl
 */
public class StringUtil {
   
    // verificar se o texto esta vazio ou com espaço
    public static boolean isNullOrEmpty(String texto){
        return texto == null || texto.trim().isEmpty();
    }
    
    //ver se o texto tem pelo menos 3 letras
    public static boolean minimoCaracter(String texto, int minimo){
        return !isNullOrEmpty(texto) && texto.trim().length() >= minimo;
    }
    
    // verifica se a duraçao é valida
    public static boolean duracaoValida(int duracao){
        return duracao > 0;
    }
}
