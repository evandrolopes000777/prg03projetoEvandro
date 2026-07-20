package br.com.ifba.academia.exercicio.service;

import br.com.ifba.academia.exercicio.entity.Exercicio;
import br.com.ifba.academia.exercicio.repository.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExercicioService implements ExercicioIService {

    @Autowired
    private ExercicioRepository exercicioRepository;

    @Override
    public Exercicio save(Exercicio exercicio) {
        if (exercicio == null) {
            throw new IllegalArgumentException("O detalhamento do exercicio nao pode ser nulo");
        }
        if (exercicio.getId() != null) {
            throw new IllegalArgumentException("O ID deve ser nulo para novos cadastros");
        }
        if (exercicio.getNome() == null || exercicio.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do exercicio e obrigatorio");
        }

        exercicio.setAtivo(true);
        return exercicioRepository.save(exercicio);
    }

    @Override
    public Exercicio update(Exercicio exercicio) {
        if (exercicio == null) {
            throw new IllegalArgumentException("Dados ausentes para a atualizacao do exercicio");
        }
        if (exercicio.getId() == null) {
            throw new IllegalArgumentException("O ID e necessario para atualizar o exercicio");
        }

        Exercicio exercicioDb = exercicioRepository.findById(exercicio.getId())
                .orElseThrow(() -> new RuntimeException("Exercicio nao localizado"));

        if (!exercicioDb.getAtivo()) {
            throw new RuntimeException("Nao e permitido alterar um exercicio inativo");
        }
        
        // Atualiza apenas os atributos permitidos do catálogo
        exercicioDb.setNome(exercicio.getNome());
        exercicioDb.setGrupoMuscular(exercicio.getGrupoMuscular());

        return exercicioRepository.save(exercicioDb);
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Informe o ID do exercicio que deseja remover");
        }

        Exercicio exercicioDb = exercicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercicio nao encontrado"));

        if (!exercicioDb.getAtivo()) {
            throw new RuntimeException("O exercicio ja consta como desativado");
        }

        exercicioDb.setAtivo(false);
        exercicioRepository.save(exercicioDb);
    }

    @Override
    public Exercicio findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID e obrigatorio na busca");
        }
        return exercicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nenhum exercicio encontrado"));
    }

    @Override
    public List<Exercicio> findAll() {
        return exercicioRepository.findByAtivoTrue();
    }
}