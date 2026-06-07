
package com.ifba.academia.repository;

import com.ifba.academia.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author evandro
 */

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    
}
