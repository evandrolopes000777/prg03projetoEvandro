package br.com.ifba.academia.exercicio.controller;

import br.com.ifba.academia.exercicio.entity.Exercicio;
import br.com.ifba.academia.exercicio.service.ExercicioIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class ExercicioController implements ExercicioIController {

    @Autowired
    private ExercicioIService exercicioService;

    @Override
    public Exercicio save(Exercicio exercicio) { return exercicioService.save(exercicio); }

    @Override
    public Exercicio update(Exercicio exercicio) { return exercicioService.update(exercicio); }

    @Override
    public void delete(Long id) { exercicioService.delete(id); }

    @Override
    public List<Exercicio> findAll() { return exercicioService.findAll(); }

    @Override
    public Exercicio findById(Long id) { return exercicioService.findById(id); }
}