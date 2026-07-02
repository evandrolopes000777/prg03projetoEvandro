package com.ifba.academia.repository;

import com.ifba.academia.model.Pagamento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author evandro
 */
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    
    List<Pagamento> findByAlunoId(Long alunoId);
    
}
