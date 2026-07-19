package br.com.ifba.academia.planoaluno.controller;

import br.com.ifba.academia.planoaluno.entity.PlanoAluno;
import java.util.List;

public interface PlanoAlunoIController {
    PlanoAluno save(PlanoAluno planoAluno);
    List<PlanoAluno> findAll();
}