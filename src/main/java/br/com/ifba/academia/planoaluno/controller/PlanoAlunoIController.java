package br.com.ifba.academia.planoaluno.controller;

import br.com.ifba.academia.planoaluno.entity.PlanoAluno;
import java.util.List;

public interface PlanoAlunoIController {
    
    PlanoAluno findById(Long id);
    
    List<PlanoAluno> findAll();
    
    void delete(Long id);
    
    PlanoAluno save(PlanoAluno planoAluno);
    
    PlanoAluno update(PlanoAluno planoAluno);
    
}