package com.ifba.academia.service;

import com.ifba.academia.model.Exercicio;
import com.ifba.academia.repository.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author evandro
 */
@Service
public class ExercicioService {

    @Autowired
    private ExercicioRepository repository;

    // CREATE e UPDATE
    public Exercicio salvar(Exercicio exercicio) {
        return repository.save(exercicio);
    }

    // READ (Ler todos os exercícios cadastrados no sistema)
    public List<Exercicio> listarTodos() {
        return repository.findAll();
    }

    // READ (Ler apenas os exercícios de uma ficha específica)
    public List<Exercicio> buscarPorFicha(Long fichaTreinoId) {
        return repository.findByFichaTreinoId(fichaTreinoId);
    }

    // READ (Ler apenas um exercício específico pelo seu ID)
    public Optional<Exercicio> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // DELETE
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}