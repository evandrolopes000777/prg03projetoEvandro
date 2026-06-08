package com.ifba.academia.model;

import jakarta.persistence.*;
import lombok.*;

/**
 *
 * @author evandro
 */

@Entity
@Table(name = "exercicios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Exercicio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private Integer series;

    @Column(nullable = false)
    private Integer repeticoes;

    @Column(nullable = false)
    private Double carga;

    @ManyToOne
    @JoinColumn(name = "ficha_treino_id", nullable = false)
    private FichaTreino fichaTreino;
    
}
