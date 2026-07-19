package br.com.ifba.academia.controleacesso.service;

import br.com.ifba.academia.pagamento.entity.Pagamento;
import br.com.ifba.academia.pagamento.repository.PagamentoRepository;
import br.com.ifba.academia.planoaluno.entity.PlanoAluno;
import br.com.ifba.academia.planoaluno.repository.PlanoAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ControleAcessoService implements ControleAcessoIService {

    @Autowired
    private PlanoAlunoRepository planoAlunoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Override
    public String validarAcesso(Long alunoId) {
        if (alunoId == null) {
            throw new IllegalArgumentException("O ID do aluno e obrigatorio para verificar a liberacao da catraca.");
        }

        Optional<PlanoAluno> planoAtivoOpt = planoAlunoRepository.findByAlunoIdAndAtivoTrue(alunoId);

        if (planoAtivoOpt.isEmpty()) {
            return "ACESSO NEGADO: O aluno nao possui nenhum plano ativo vinculado na academia.";
        }

        PlanoAluno planoAluno = planoAtivoOpt.get();

        if (LocalDate.now().isAfter(planoAluno.getDataVencimento())) {
            return "ACESSO NEGADO: O plano atual do aluno encontra-se vencido.";
        }

        List<Pagamento> pagamentos = pagamentoRepository.findByAlunoIdAndAtivoTrue(alunoId);

        if (pagamentos.isEmpty()) {
            return "ACESSO NEGADO: Pendencia financeira. Nenhum pagamento registrado para este aluno.";
        }

        boolean possuiPagamentoNoPeriodo = false;
        
        for (Pagamento pagamento : pagamentos) {
            if (!pagamento.getDataPagamento().isBefore(planoAluno.getDataInicio())) {
                possuiPagamentoNoPeriodo = true;
                break;
            }
        }

        if (!possuiPagamentoNoPeriodo) {
            return "ACESSO NEGADO: Pendencia financeira. Nenhum pagamento registrado referente ao periodo do plano atual.";
        }

        return "ACESSO LIBERADO";
    }
}