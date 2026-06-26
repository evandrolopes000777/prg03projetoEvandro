package com.ifba.academia.repository;

import com.ifba.academia.model.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 *
 * @author evandro
 */
@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
    
    // buscar exercícios de um treino específico
    List<Exercicio> findByFichaTreinoId(Long fichaTreinoId);
    
}
