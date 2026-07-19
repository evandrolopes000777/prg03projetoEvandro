package br.com.ifba.academia.pessoa.repository;

import br.com.ifba.academia.pessoa.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
    boolean existsByCpf(String cpf);
    
    List<Pessoa> findByAtivoTrue();
    
    List<Pessoa> findByNomeContainingIgnoreCase(String nome);
}