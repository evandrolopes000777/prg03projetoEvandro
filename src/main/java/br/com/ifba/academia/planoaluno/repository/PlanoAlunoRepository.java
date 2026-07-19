package br.com.ifba.academia.planoaluno.repository;

import br.com.ifba.academia.planoaluno.entity.PlanoAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlanoAlunoRepository extends JpaRepository<PlanoAluno, Long> {
    
    Optional<PlanoAluno> findByAlunoIdAndAtivoTrue(Long alunoId);
    
    List<PlanoAluno> findByAtivoTrue();
}