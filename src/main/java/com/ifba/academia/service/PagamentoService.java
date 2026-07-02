package com.ifba.academia.service;

import com.ifba.academia.model.Pagamento;
import com.ifba.academia.repository.PagamentoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author evandro
 */
@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Transactional
    public Pagamento salvar(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public List<Pagamento> listarTodos() {
        return pagamentoRepository.findAll();
    }

    public Optional<Pagamento> buscarPorId(Long id) {
        return pagamentoRepository.findById(id);
    }

    public List<Pagamento> buscarPorAlunoId(Long alunoId) {
        return pagamentoRepository.findByAlunoId(alunoId);
    }

    @Transactional
    public void excluir(Long id) {
        try {
            pagamentoRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Não é possível excluir ou estornar este pagamento, pois existem outros registros vinculados a ele no sistema.");
        }
    }
}