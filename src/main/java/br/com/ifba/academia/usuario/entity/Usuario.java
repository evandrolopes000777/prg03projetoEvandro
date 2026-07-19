package br.com.ifba.academia.usuario.entity;

import br.com.ifba.academia.infrastructure.entity.PersistenceEntity;
import br.com.ifba.academia.pessoa.entity.Pessoa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Usuario extends PersistenceEntity {

    @Column(name = "login", nullable = false, unique = true, length = 50)
    private String login;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "perfil", nullable = false, length = 20)
    private String perfil; // Deve ser somente "ADMIN" ou "ALUNO"

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    @OneToOne
    @JoinColumn(name = "pessoa_id", nullable = false, unique = true)
    private Pessoa pessoa;
}