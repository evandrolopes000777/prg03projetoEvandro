package com.ifba.academia.service;

import com.ifba.academia.model.Plano;
import com.ifba.academia.repository.PlanoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author evandro
 */
@Service
public class PlanoService {
    
    @Autowired
    private PlanoRepository repository;

    public List<Plano> listarTodos() {
        return repository.findAll();
    }
}
