package com.ifba.academia.service;

import com.ifba.academia.model.Aluno;
import com.ifba.academia.repository.AlunoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author evandro
 */
@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    // CREATE e UPDATE
    public Aluno salvar(Aluno aluno) {
        return repository.save(aluno);
    }

    // READ (Ler todos os alunos cadastrados)
    public List<Aluno> listarTodos() {
        return repository.findAll();
    }

    // READ (Ler apenas um aluno)
    public Optional<Aluno> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // DELETE
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
