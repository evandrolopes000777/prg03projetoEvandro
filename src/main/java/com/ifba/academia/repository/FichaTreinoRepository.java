package com.ifba.academia.repository;

import com.ifba.academia.model.FichaTreino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 *
 * @author evandro
 */

@Repository
public interface FichaTreinoRepository extends JpaRepository<FichaTreino, Long> {
    Optional<FichaTreino> findTopByAlunoIdOrderByDataCriacaoDesc(Long alunoId);
}
