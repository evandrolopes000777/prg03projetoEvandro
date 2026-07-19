package br.com.ifba.academia.fichatreino.repository;

import br.com.ifba.academia.fichatreino.entity.FichaTreino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface FichaTreinoRepository extends JpaRepository<FichaTreino, Long> {
    
    List<FichaTreino> findByAtivoTrue();
    
    List<FichaTreino> findByAlunoIdAndAtivoTrue(Long alunoId);
    
    Optional<FichaTreino> findTopByAlunoIdAndAtivoTrueOrderByDataCriacaoDesc(Long alunoId);
}