package br.com.ifba.academia.pagamento.controller;

import br.com.ifba.academia.pagamento.entity.Pagamento;
import java.util.List;

public interface PagamentoIController {
    
    Pagamento findById(Long id);
    
    List<Pagamento> findAll();
    
    List<Pagamento> findByAlunoId(Long alunoId);
    
    void delete(Long id);
    
    Pagamento save(Pagamento pagamento);
    
    Pagamento update(Pagamento pagamento);
    
}