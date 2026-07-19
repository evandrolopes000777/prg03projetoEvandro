package br.com.ifba.academia.fichatreino.entity;

import br.com.ifba.academia.infrastructure.entity.PersistenceEntity;
import br.com.ifba.academia.pessoa.entity.Pessoa;
import br.com.ifba.academia.exercicio.entity.Exercicio;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "fichas_treino")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class FichaTreino extends PersistenceEntity {

    @Column(name = "descricao", nullable = false, length = 200)
    private String descricao;

    @Column(name = "data_criacao", nullable = false)
    private LocalDate dataCriacao;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Pessoa aluno;

    @ToString.Exclude
    @OneToMany(mappedBy = "fichaTreino", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Exercicio> exercicios = new ArrayList<>();

    public void adicionarExercicio(Exercicio exercicio) {
        if (!exercicios.contains(exercicio)) {
            exercicios.add(exercicio);
            exercicio.setFichaTreino(this);
        }
    }

    public void removerExercicio(Exercicio exercicio) {
        if (exercicios.contains(exercicio)) {
            exercicios.remove(exercicio);
            exercicio.setFichaTreino(null);
        }
    }
}