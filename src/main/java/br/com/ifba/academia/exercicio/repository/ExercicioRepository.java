package br.com.ifba.academia.exercicio.repository;

import br.com.ifba.academia.exercicio.entity.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
    
    List<Exercicio> findByAtivoTrue();
    
}