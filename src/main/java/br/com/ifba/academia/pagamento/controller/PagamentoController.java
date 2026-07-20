package br.com.ifba.academia.pagamento.controller;

import br.com.ifba.academia.pagamento.entity.Pagamento;
import br.com.ifba.academia.pagamento.service.PagamentoIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class PagamentoController implements PagamentoIController {

    @Autowired
    private PagamentoIService pagamentoService;

    @Override
    public Pagamento findById(Long id) { return pagamentoService.findById(id); }

    @Override
    public List<Pagamento> findAll() { return pagamentoService.findAll(); }

    @Override
    public List<Pagamento> findByAlunoId(Long alunoId) { return pagamentoService.findByAlunoId(alunoId); }

    @Override
    public void delete(Long id) { pagamentoService.delete(id); }

    @Override
    public Pagamento save(Pagamento pagamento) { return pagamentoService.save(pagamento); }

    @Override
    public Pagamento update(Pagamento pagamento) { return pagamentoService.update(pagamento); }
}