package com.ifba.academia.service;

import com.ifba.academia.model.PlanoAluno;
import com.ifba.academia.repository.PlanoAlunoRepository;
import java.time.LocalDate;
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
    
    public PlanoAluno matricular(com.ifba.academia.model.Aluno aluno, com.ifba.academia.model.Plano plano) {
        
        PlanoAluno planoAtual = buscarPlanoAtivo(aluno.getId());
        if (planoAtual != null) {
            planoAtual.setAtivo(false);
            repository.save(planoAtual);
        }
        
        PlanoAluno novaMatricula = new PlanoAluno();
        novaMatricula.setAluno(aluno);
        novaMatricula.setPlano(plano);
        
        LocalDate hoje = LocalDate.now();
        novaMatricula.setDataInicio(hoje);
        
        //Calcula o vencimento (Hoje + dias de duração do pacote)
        novaMatricula.setDataVencimento(hoje.plusDays(plano.getDuracaoDias()));
        novaMatricula.setAtivo(true);
        
        return repository.save(novaMatricula);
    }
}
