package com.ifba.academia.repository;

import com.ifba.academia.model.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



/**
 *
 * @author evandro
 */
@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long> {
    
}
