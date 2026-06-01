package com.ifba.academia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "administradores")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

/**
 *
 * @author evandro
 */
public class Administrador extends Usuario{
    
}
