package br.com.ifba.academia.pessoa.service;

import br.com.ifba.academia.pessoa.entity.Pessoa;
import java.util.List;

public interface PessoaIService {
    
    Pessoa findById(Long id);

    List<Pessoa> findAll();
        
    List<Pessoa> findByNome(String nome);
    
    void delete(Long id);
    
    Pessoa save(Pessoa pessoa);
    
    Pessoa update(Pessoa pessoa);
    
}