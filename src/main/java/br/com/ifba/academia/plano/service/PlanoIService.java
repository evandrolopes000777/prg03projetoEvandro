package br.com.ifba.academia.plano.service;

import br.com.ifba.academia.plano.entity.Plano;
import java.util.List;

public interface PlanoIService {
    
    Plano findById(Long id);

    List<Plano> findAll();

    List<Plano> findByNome(String nome);
    
    void delete(Long id);

    Plano save(Plano plano);

    Plano update(Plano plano);

    
}
