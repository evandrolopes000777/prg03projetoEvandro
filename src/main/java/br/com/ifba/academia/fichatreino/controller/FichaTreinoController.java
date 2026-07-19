package br.com.ifba.academia.fichatreino.controller;

import br.com.ifba.academia.fichatreino.entity.FichaTreino;
import br.com.ifba.academia.fichatreino.service.FichaTreinoIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FichaTreinoController implements FichaTreinoIController {

    @Autowired
    private FichaTreinoIService fichaTreinoService;

    @Override
    public FichaTreino buscarFichaAtual(Long idPessoa) { return fichaTreinoService.buscarFichaAtual(idPessoa); }
    
    @Override
    public FichaTreino findById(Long id) { return fichaTreinoService.findById(id); }
}