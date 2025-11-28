/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.repository;

import br.com.ifba.entity.Curso;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author crisl
 */
public interface CursoRepository extends JpaRepository<Curso, Long> {
  
    // Busca cursos cujo nome contenha o texto, ignorando maiúsculas/minúsculas
    List<Curso> findByNomeContainingIgnoreCase(String nome);
    
    // Busca cursos pela plataforma
    List<Curso> findByPlataformaContainingIgnoreCase(String plataforma);

}

