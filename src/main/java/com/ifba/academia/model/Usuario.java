package com.ifba.academia.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

/**
 *
 * @author evandro
 */
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    protected Long id;

    @Column(nullable = false, length = 100)
    protected String nome;

    @Column(nullable = false, unique = true, length = 50)
    protected String login;

    @Column(nullable = false)
    protected String senha;

    @Column(nullable = false, length = 20)
    protected String perfil; // "ADMIN" ou "ALUNO"
}
