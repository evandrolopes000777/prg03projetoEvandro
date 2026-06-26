package com.ifba.academia.service;

import com.ifba.academia.model.Plano;
import com.ifba.academia.repository.PlanoRepository;
import java.util.List;
import java.util.Optional;
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

    // CREATE e UPDATE
    public Plano salvar(Plano plano) {
        return repository.save(plano);
    }

    // READ (Ler todos)
    public List<Plano> listarTodos() {
        return repository.findAll();
    }

    // READ (Ler específico por ID para poder editar)
    public Optional<Plano> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // DELETE (Excluir um plano que a academia não vende mais)
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}