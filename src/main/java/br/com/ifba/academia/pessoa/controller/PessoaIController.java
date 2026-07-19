package br.com.ifba.academia.pessoa.controller;

import br.com.ifba.academia.pessoa.entity.Pessoa;
import java.util.List;

public interface PessoaIController {
    
    List<Pessoa> findAll();
    
    Pessoa findById(Long id);
    
    void delete(Long id);
    
    Pessoa save(Pessoa pessoa);
    
    Pessoa update(Pessoa pessoa);
}