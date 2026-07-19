package br.com.ifba.academia.plano.repository;

import br.com.ifba.academia.plano.entity.Plano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long>{
    
    public List<Plano> findByAtivoTrue();

    public List<Plano> findByNomeContainingIgnoreCase(String nome);

    public List<Plano> findByAtivoTrueAndNomeContainingIgnoreCase(String nome);
}
