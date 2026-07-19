package br.com.ifba.academia.fichatreino.service;

import br.com.ifba.academia.fichatreino.entity.FichaTreino;
import br.com.ifba.academia.fichatreino.repository.FichaTreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class FichaTreinoService implements FichaTreinoIService {

    @Autowired
    private FichaTreinoRepository fichaTreinoRepository;

    @Override
    public FichaTreino save(FichaTreino ficha) {
        if (ficha == null) {
            throw new IllegalArgumentException("Os dados da ficha de treino estao nulos");
        }
        if (ficha.getId() != null) {
            throw new IllegalArgumentException("O ID deve ser nulo");
        }
        if (ficha.getAluno() == null || ficha.getAluno().getId() == null) {
            throw new IllegalArgumentException("O aluno da ficha e obrigatorio");
        }
        if (ficha.getDescricao() == null || ficha.getDescricao().trim().isEmpty()) {
            throw new IllegalArgumentException("descricao do treino e obrigatoria (Ex: Treino A - Hipertrofia)");
        }
        if (ficha.getDataCriacao() == null) {
            ficha.setDataCriacao(LocalDate.now());
        }
        
        ficha.setAtivo(true);
        return fichaTreinoRepository.save(ficha);
    }

    @Override
    public FichaTreino update(FichaTreino ficha) {
        if (ficha == null) {
            throw new IllegalArgumentException("Nenhum dado informado para a atualizacao da ficha");
        }
        if (ficha.getId() == null) {
            throw new IllegalArgumentException("O ID da ficha e obrigatori");
        }
        
        FichaTreino fichaDb = fichaTreinoRepository.findById(ficha.getId())
                .orElseThrow(() -> new RuntimeException("Ficha de treino nao localizada"));
                
        if (!fichaDb.getAtivo()) {
            throw new RuntimeException("Nao e possivel alterar uma ficha de treino que ja foi cancelada");
        }
        if (ficha.getDescricao() == null || ficha.getDescricao().trim().isEmpty()) {
            throw new IllegalArgumentException("A descricao atualizada nao pode ficar em branco");
        }

        fichaDb.setDescricao(ficha.getDescricao());
        return fichaTreinoRepository.save(fichaDb);
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID nao pode estar nulo");
        }
        
        FichaTreino fichaDb = fichaTreinoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nenhuma ficha de treino localizada"));
                
        if (!fichaDb.getAtivo()) {
            throw new RuntimeException("Esta ficha de treino ja encontra-se desativada");
        }
        
        fichaDb.setAtivo(false);
        fichaTreinoRepository.save(fichaDb);
    }

    @Override
    public FichaTreino findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID e obrigatorio");
        }
        return fichaTreinoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ficha de treino inexistente"));
    }

    @Override
    public List<FichaTreino> findAll() {
        return fichaTreinoRepository.findByAtivoTrue();
    }

    @Override
    public List<FichaTreino> findByAlunoId(Long alunoId) {
        if (alunoId == null) {
            throw new IllegalArgumentException("Informe o ID do aluno para visualizar seus treinos");
        }
        return fichaTreinoRepository.findByAlunoIdAndAtivoTrue(alunoId);
    }

    @Override
    public FichaTreino buscarFichaAtual(Long alunoId) {
        if (alunoId == null) {
            throw new IllegalArgumentException("Informe o ID do aluno para buscar o treino mais recente");
        }
        return fichaTreinoRepository.findTopByAlunoIdAndAtivoTrueOrderByDataCriacaoDesc(alunoId)
                .orElseThrow(() -> new RuntimeException("Este aluno nao possui nenhuma ficha de treino ativa"));
    }
}