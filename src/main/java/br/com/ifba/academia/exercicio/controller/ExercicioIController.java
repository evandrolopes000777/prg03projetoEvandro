package br.com.ifba.academia.exercicio.controller;

import br.com.ifba.academia.exercicio.entity.Exercicio;
import java.util.List;

public interface ExercicioIController {
    
    Exercicio save(Exercicio exercicio);
    
    Exercicio update(Exercicio exercicio);
    
    void delete(Long id);
    
    List<Exercicio> findAll();
    
    Exercicio findById(Long id);
    
}