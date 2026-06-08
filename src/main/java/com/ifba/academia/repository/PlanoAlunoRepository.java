package com.ifba.academia.repository;

import com.ifba.academia.model.PlanoAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 *
 * @author evandro
 */

@Repository
public interface PlanoAlunoRepository extends JpaRepository<PlanoAluno, Long> {
    
    Optional<PlanoAluno> findByAlunoIdAndAtivoTrue(Long alunoId);
    
}
