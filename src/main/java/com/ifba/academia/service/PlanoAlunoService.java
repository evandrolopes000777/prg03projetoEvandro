package com.ifba.academia.service;

import com.ifba.academia.model.PlanoAluno;
import com.ifba.academia.repository.PlanoAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 *
 * @author evandro
 */

@Service
public class PlanoAlunoService {
    
    @Autowired
    private PlanoAlunoRepository repository;

    public PlanoAluno buscarPlanoAtivo(Long alunoId) {
        Optional<PlanoAluno> planoEncontrado = repository.findByAlunoIdAndAtivoTrue(alunoId);
        return planoEncontrado.orElse(null);
    }
}
