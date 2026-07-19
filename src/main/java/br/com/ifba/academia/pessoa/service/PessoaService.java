package br.com.ifba.academia.pessoa.service;

import br.com.ifba.academia.pessoa.entity.Pessoa;
import br.com.ifba.academia.pessoa.repository.PessoaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService implements PessoaIService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public List<Pessoa> findAll() {
        return pessoaRepository.findByAtivoTrue();
    }

    @Override
    public Pessoa findById(Long id) {
        if (id != null) {
            return pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro de pessoa nao encontrado"));
        }
        throw new IllegalArgumentException("O ID para busca nao pode ser nulo");
    }

    @Override
    public List<Pessoa> findByNome(String nome) {
        if (nome != null && !nome.isBlank()) {
            return pessoaRepository.findByNomeContainingIgnoreCase(nome);
        }
        throw new IllegalArgumentException("O nome para a pesquisa de alunos/funcionarios e obrigatorio");
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        if (pessoa == null) {
            throw new IllegalArgumentException("Os dados da pessoa estao nulos");
        }
        if (pessoa.getId() != null) {
            throw new IllegalArgumentException("Para cadastrar uma nova pessoa na academia o ID deve ser nulo");
        }
        if (pessoaRepository.existsByCpf(pessoa.getCpf())) {
            throw new RuntimeException("já existe uma pessoa com este CPF ja cadastrado no sistema");
        }
        
        pessoa.setAtivo(true);
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Pessoa update(Pessoa pessoa) {
        if (pessoa == null) {
            throw new IllegalArgumentException("Os dados da pessoa nao podem ser nulos");
        }
        if (pessoa.getId() != null) {
            if (pessoaRepository.existsById(pessoa.getId())) {
                return pessoaRepository.save(pessoa);
            }
            throw new RuntimeException("Pessoa nao encontrada");
        }
        throw new IllegalArgumentException("Para atualizar os dados o ID e obrigatorio.");
    }

    @Override
    public void delete(Long id) {
        if (id != null) {
            Pessoa pessoaDb = pessoaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Nenhuma pessoa encontrada"));

            if (Boolean.TRUE.equals(pessoaDb.getAtivo())) {
                pessoaDb.setAtivo(false);
                pessoaRepository.save(pessoaDb);
                return;
            }
            throw new RuntimeException("Esta pessoa ja consta como inativa no sistema");
        }
        throw new IllegalArgumentException("O ID da pessoa nao pode ser nulo");
    }
}