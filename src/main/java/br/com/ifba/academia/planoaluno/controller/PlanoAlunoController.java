package br.com.ifba.academia.planoaluno.controller;

import br.com.ifba.academia.planoaluno.entity.PlanoAluno;
import br.com.ifba.academia.planoaluno.service.PlanoAlunoIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class PlanoAlunoController implements PlanoAlunoIController {

    @Autowired
    private PlanoAlunoIService planoAlunoService;

    @Override
    public PlanoAluno findById(Long id) { return planoAlunoService.findById(id); }

    @Override
    public List<PlanoAluno> findAll() { return planoAlunoService.findAll(); }

    @Override
    public void delete(Long id) { planoAlunoService.delete(id); }

    @Override
    public PlanoAluno save(PlanoAluno planoAluno) { return planoAlunoService.save(planoAluno); }

    @Override
    public PlanoAluno update(PlanoAluno planoAluno) { return planoAlunoService.update(planoAluno); }
}