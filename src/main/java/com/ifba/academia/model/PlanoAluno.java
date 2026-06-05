package com.ifba.academia.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.*;

/**
 *
 * @author evandro
 */

@Entity
@Table (name = "planos_alunos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PlanoAluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;
    
    @ManyToOne
    @JoinColumn(name = "plano_id", nullable = false)
    private Plano plano;
    
    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "data_vencimento", nullable = false)
    private LocalDate dataVencimento;

    @Column(nullable = false)
    private Boolean ativo;
}
