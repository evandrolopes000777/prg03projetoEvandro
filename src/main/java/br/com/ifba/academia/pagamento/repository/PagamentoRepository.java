package br.com.ifba.academia.pagamento.repository;

import br.com.ifba.academia.pagamento.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    
    List<Pagamento> findByAlunoIdAndAtivoTrue(Long alunoId);
    
    List<Pagamento> findByAtivoTrue();
}