package br.com.ifba.academia.planoaluno.service;

import br.com.ifba.academia.planoaluno.entity.PlanoAluno;
import br.com.ifba.academia.planoaluno.repository.PlanoAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PlanoAlunoService implements PlanoAlunoIService {

    @Autowired
    private PlanoAlunoRepository planoAlunoRepository;

    @Override
    public PlanoAluno save(PlanoAluno planoAluno) {
        if (planoAluno == null) {
            throw new IllegalArgumentException("Os dados nao podem ser nulos.");
        }
        if (planoAluno.getId() != null) {
            throw new IllegalArgumentException("o ID deve ser nulo.");
        }
        if (planoAluno.getAluno() == null || planoAluno.getAluno().getId() == null) {
            throw new IllegalArgumentException("O aluno e estritamente obrigatorio para realizar o vinculo.");
        }
        if (planoAluno.getPlano() == null || planoAluno.getPlano().getId() == null) {
            throw new IllegalArgumentException("O plano da academia deve ser selecionado para o vinculo.");
        }

        Optional<PlanoAluno> planoAtivo = planoAlunoRepository.findByAlunoIdAndAtivoTrue(planoAluno.getAluno().getId());
        if (planoAtivo.isPresent()) {
            throw new RuntimeException("Este aluno ja possui um plano ativo. Aguarde o vencimento ou cancele o atual.");
        }

        if (planoAluno.getDataInicio() == null) {
            planoAluno.setDataInicio(LocalDate.now());
        }

        if (planoAluno.getPlano().getDuracaoDias() == null || planoAluno.getPlano().getDuracaoDias() <= 0) {
            throw new IllegalArgumentException("O plano selecionado possui uma duracao invalida.");
        }

        planoAluno.setDataVencimento(planoAluno.getDataInicio().plusDays(planoAluno.getPlano().getDuracaoDias()));
        planoAluno.setAtivo(true);
        
        return planoAlunoRepository.save(planoAluno);
    }

    @Override
    public PlanoAluno update(PlanoAluno planoAluno) {
        if (planoAluno == null) {
            throw new IllegalArgumentException("Nenhum dado informado para a atualizacao");
        }
        if (planoAluno.getId() == null) {
            throw new IllegalArgumentException("O ID e obrigatorio para qualquer atualizacao.");
        }
        if (!planoAlunoRepository.existsById(planoAluno.getId())) {
            throw new RuntimeException("Registro plano nao encontrado no banco de dados.");
        }
        if (planoAluno.getAluno() == null || planoAluno.getPlano() == null) {
            throw new IllegalArgumentException("Para atualizar, os objetos de Aluno e Plano nao podem ser removidos.");
        }

        return planoAlunoRepository.save(planoAluno);
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID nao pode estar nulo para cancelar um plano.");
        }
        
        PlanoAluno planoAlunoDb = planoAlunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vinculo de plano inexistente"));

        if (!planoAlunoDb.getAtivo()) {
            throw new RuntimeException("Aviso: O plano selecionado ja encontra-se cancelado ou inativo.");
        }

        planoAlunoDb.setAtivo(false);
        planoAlunoRepository.save(planoAlunoDb);
    }

    @Override
    public PlanoAluno findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("informe um ID valido.");
        }
        return planoAlunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nenhum plano foi localizado para este ID."));
    }

    @Override
    public List<PlanoAluno> findAll() {
        return planoAlunoRepository.findByAtivoTrue();
    }
}