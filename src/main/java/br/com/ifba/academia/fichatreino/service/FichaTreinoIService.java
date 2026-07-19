package br.com.ifba.academia.fichatreino.service;

import br.com.ifba.academia.fichatreino.entity.FichaTreino;
import java.util.List;

public interface FichaTreinoIService {
    
    FichaTreino findById(Long id);
    
    List<FichaTreino> findAll();
    
    List<FichaTreino> findByAlunoId(Long alunoId);
    
    FichaTreino buscarFichaAtual(Long alunoId);
    
    void delete(Long id);
    
    FichaTreino save(FichaTreino ficha);
    
    FichaTreino update(FichaTreino ficha);
    
}