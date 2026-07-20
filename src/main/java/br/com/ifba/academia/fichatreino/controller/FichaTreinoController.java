package br.com.ifba.academia.fichatreino.controller;

import br.com.ifba.academia.fichatreino.entity.FichaTreino;
import br.com.ifba.academia.fichatreino.service.FichaTreinoIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class FichaTreinoController implements FichaTreinoIController {

    @Autowired
    private FichaTreinoIService fichaTreinoService;

    @Override
    public FichaTreino findById(Long id) { return fichaTreinoService.findById(id); }

    @Override
    public List<FichaTreino> findAll() { return fichaTreinoService.findAll(); }

    @Override
    public List<FichaTreino> findByAlunoId(Long alunoId) { return fichaTreinoService.findByAlunoId(alunoId); }

    @Override
    public FichaTreino buscarFichaAtual(Long alunoId) { return fichaTreinoService.buscarFichaAtual(alunoId); }

    @Override
    public void delete(Long id) { fichaTreinoService.delete(id); }

    @Override
    public FichaTreino save(FichaTreino ficha) { return fichaTreinoService.save(ficha); }

    @Override
    public FichaTreino update(FichaTreino ficha) { return fichaTreinoService.update(ficha); }
}