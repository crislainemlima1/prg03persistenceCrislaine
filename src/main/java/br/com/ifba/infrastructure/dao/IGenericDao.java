/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import java.util.List;

/**
 *
 * @author crisl
 * @param <T>
 */

public interface IGenericDao<T> {
    void salvar(T entidade);
    void atualizar(T entidade);
    void excluir(T entidade);
    T buscarPorId(Long id);
    List<T> listarTodos();
}

