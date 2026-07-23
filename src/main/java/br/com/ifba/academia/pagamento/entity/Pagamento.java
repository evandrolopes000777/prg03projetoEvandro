package br.com.ifba.academia.pagamento.entity;

import br.com.ifba.academia.infrastructure.entity.PersistenceEntity;
import br.com.ifba.academia.pessoa.entity.Pessoa;
import br.com.ifba.academia.plano.entity.Plano;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pagamentos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Pagamento extends PersistenceEntity {

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Pessoa aluno;
    
    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Plano plano;

    @Column(name = "valor", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(name = "data_pagamento", nullable = false)
    private LocalDate dataPagamento;

    @Column(name = "forma_pagamento", nullable = false, length = 20)
    private String formaPagamento;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;
}