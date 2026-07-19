package br.com.ifba.academia.plano.entity;

import br.com.ifba.academia.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "plano")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Plano extends PersistenceEntity{
    @Column(nullable = false, name = "ativo")
    private Boolean ativo = true;

    @Column(nullable = false, name = "nome")
    private String nome;

    @Column(nullable = false, name = "duracao_dias")
    private Integer duracaoDias;

    @Column(nullable = false, name = "valor")
    private BigDecimal valor;
}
