package br.com.ifba.academia.pagamento.service;

import br.com.ifba.academia.pagamento.entity.Pagamento;
import br.com.ifba.academia.pagamento.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class PagamentoService implements PagamentoIService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Override
    public Pagamento save(Pagamento pagamento) {
        if (pagamento == null) {
            throw new IllegalArgumentException("Os dados do pagamento nao podem ser nulos");
        }
        if (pagamento.getId() != null) {
            throw new IllegalArgumentException("Nao e permitido informar um ID para um novo pagamento");
        }
        if (pagamento.getAluno() == null || pagamento.getAluno().getId() == null) {
            throw new IllegalArgumentException("O aluno e obrigatorio para registrar a transacao");
        }
        if (pagamento.getValor() == null || pagamento.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor do pagamento deve ser maior que zero");
        }
        if (pagamento.getFormaPagamento() == null || pagamento.getFormaPagamento().trim().isEmpty()) {
            throw new IllegalArgumentException("A forma de pagamento (Dinheiro, PIX, Cartao) e obrigatoria");
        }

        if (pagamento.getDataPagamento() == null) {
            pagamento.setDataPagamento(LocalDate.now());
        }
        
        pagamento.setAtivo(true);
        return pagamentoRepository.save(pagamento);
    }

    @Override
    public Pagamento update(Pagamento pagamento) {
        if (pagamento == null) {
            throw new IllegalArgumentException("Os dados do pagamento nao podem ser nulos para atualizacao");
        }
        if (pagamento.getId() == null) {
            throw new IllegalArgumentException("O ID do pagamento e obrigatorio para realizar alteracoes");
        }
        
        Pagamento pagamentoDb = pagamentoRepository.findById(pagamento.getId())
                .orElseThrow(() -> new RuntimeException("Pagamento nao encontrado"));

        if (!pagamentoDb.getAtivo()) {
            throw new RuntimeException("Nao e permitido alterar um pagamento que ja foi cancelado");
        }

        if (pagamento.getValor() == null || pagamento.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor atualizado deve ser maior que zero");
        }
        if (pagamento.getFormaPagamento() == null || pagamento.getFormaPagamento().trim().isEmpty()) {
            throw new IllegalArgumentException("A forma de pagamento e obrigatoria");
        }

        pagamentoDb.setValor(pagamento.getValor());
        pagamentoDb.setFormaPagamento(pagamento.getFormaPagamento());

        return pagamentoRepository.save(pagamentoDb);
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID nao pode ser nulo para estornar um pagamento");
        }

        Pagamento pagamentoDb = pagamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro de pagamento inexistente com o ID informado"));

        if (!pagamentoDb.getAtivo()) {
            throw new RuntimeException("Esta transacao ja consta como estornada ou inativa");
        }

        pagamentoDb.setAtivo(false);
        pagamentoRepository.save(pagamentoDb);
    }

    @Override
    public Pagamento findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Informe um ID valido para buscar o pagamento");
        }
        return pagamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento nao localizado"));
    }

    @Override
    public List<Pagamento> findAll() {
        return pagamentoRepository.findByAtivoTrue();
    }

    @Override
    public List<Pagamento> findByAlunoId(Long alunoId) {
        if (alunoId == null) {
            throw new IllegalArgumentException("O ID do aluno e obrigatorio para listar os pagamentos");
        }
        return pagamentoRepository.findByAlunoIdAndAtivoTrue(alunoId);
    }
}