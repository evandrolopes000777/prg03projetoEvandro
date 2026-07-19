package br.com.ifba.academia.fichatreino.controller;

import br.com.ifba.academia.fichatreino.entity.FichaTreino;

public interface FichaTreinoIController {
    FichaTreino buscarFichaAtual(Long idPessoa);
    FichaTreino findById(Long id);
}