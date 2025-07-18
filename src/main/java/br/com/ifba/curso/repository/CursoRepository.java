/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.curso.repository;

/**
 *
 * @author crisl
 */
import br.com.ifba.curso.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    // Buscar por nome exato
    List<Curso> findByNome(String nome);

    // busca por nome parcial ignorando maiusculo e minusculo
    List<Curso> findByNomeContainingIgnoreCase(String nome);

    // Buscar por plataforma especifica
    List<Curso> findByPlataforma(String plataforma);

    // Buscar cursos sem desciçao
    List<Curso> findByDescricaoIsNull();

    // Buscar cursos com duração inferior a X horas
    List<Curso> findByDuracaoLessThan(int duracao);

    // Buscar cursos com duração a partir de X horas
    List<Curso> findByDuracaoGreaterThanEqual(int duracao);
}




