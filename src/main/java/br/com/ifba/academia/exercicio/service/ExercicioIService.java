package br.com.ifba.academia.exercicio.service;

import br.com.ifba.academia.exercicio.entity.Exercicio;
import java.util.List;

public interface ExercicioIService {
    
    Exercicio findById(Long id);
    
    List<Exercicio> findAll();
    
    void delete(Long id);
    
    Exercicio save(Exercicio exercicio);
    
    Exercicio update(Exercicio exercicio);
    
}