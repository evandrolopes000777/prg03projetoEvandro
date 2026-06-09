package com.ifba.academia.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.*;

/**
 *
 * @author evandro
 */
@Entity
@Table(name = "planos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Plano {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String nome;
    
    @Column(name = "duracao_dias", nullable = false)
    private Integer duracaoDias;
    
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;
    
}
