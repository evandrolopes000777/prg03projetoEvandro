package com.ifba.academia.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import lombok.*;

/**
 *
 * @author evandro
 */

@Entity
@Table(name = "fichas_treino")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FichaTreino {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, length = 200)
    private String descricao;

    @Column(name = "data_criacao", nullable = false)
    private LocalDate dataCriacao;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @OneToMany(mappedBy = "fichaTreino", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Exercicio> exercicios;
    
}
