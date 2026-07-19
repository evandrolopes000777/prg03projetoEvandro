package br.com.ifba.academia.exercicio.entity;

import br.com.ifba.academia.fichatreino.entity.FichaTreino;
import br.com.ifba.academia.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exercicios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Exercicio extends PersistenceEntity {

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "series", nullable = false)
    private Integer series;

    @Column(name = "repeticoes", nullable = false)
    private Integer repeticoes;

    @Column(name = "carga", nullable = false)
    private Double carga;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    @ManyToOne
    @JoinColumn(name = "ficha_treino_id", nullable = false)
    private FichaTreino fichaTreino;
}