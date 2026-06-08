package com.ifba.academia.service;

import com.ifba.academia.model.FichaTreino;
import com.ifba.academia.repository.FichaTreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 *
 * @author evandro
 */

@Service
public class FichaTreinoService {
    
    @Autowired
    private FichaTreinoRepository repository;

    public FichaTreino buscarFichaAtual(Long alunoId) {
        Optional<FichaTreino> fichaEncontrada = repository.findTopByAlunoIdOrderByDataCriacaoDesc(alunoId);
        return fichaEncontrada.orElse(null);
    }
    
}
