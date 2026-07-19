package br.com.ifba.academia.planoaluno.entity;

import br.com.ifba.academia.infrastructure.entity.PersistenceEntity;
import br.com.ifba.academia.pessoa.entity.Pessoa;
import br.com.ifba.academia.plano.entity.Plano;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "planos_alunos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PlanoAluno extends PersistenceEntity {

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Pessoa aluno;

    @ManyToOne
    @JoinColumn(name = "plano_id", nullable = false)
    private Plano plano;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "data_vencimento", nullable = false)
    private LocalDate dataVencimento;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;
}