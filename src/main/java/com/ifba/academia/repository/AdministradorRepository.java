package com.ifba.academia.repository;

import com.ifba.academia.model.Administrador;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author evandro
 */
@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    
    Optional<Administrador> findByLogin(String login);
    
}
