package br.com.ifba.academia.plano.service;

import br.com.ifba.academia.plano.entity.Plano;
import br.com.ifba.academia.plano.repository.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoService implements PlanoIService {

    @Autowired
    private PlanoRepository planoRepository;

    @Override
    public Plano findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ERRO: ID não pode ser nulo.");
        }
        return planoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ERRO: o plano não foi encontrado com o id fornecido"));
    }

    @Override
    public List<Plano> findAll() {
        return planoRepository.findByAtivoTrue();
    }

    @Override
    public List<Plano> findByNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("ERRO: o nome não pode ser vazio.");
        }
        return planoRepository.findByAtivoTrueAndNomeContainingIgnoreCase(nome);
    }

    @Override
    public Plano save(Plano plano) {
        if (plano == null) {
            throw new IllegalArgumentException("ERRO: o plano não pode ser nulo.");
        }
        if (plano.getId() != null) {
            throw new IllegalArgumentException("ERRO: o plano novo não deve ter um ID.");
        }

        plano.setAtivo(true);
        return planoRepository.save(plano);
    }

    @Override
    public Plano update(Plano plano) {
        if (plano == null || plano.getId() == null) {
            throw new IllegalArgumentException("ERRO: plano ou ID não pode ser nulo para o updatee.");
        }
        
        this.findById(plano.getId());

        return planoRepository.save(plano);
    }

    @Override
    public void delete(Long id) {
        Plano plano = this.findById(id);

        if (Boolean.FALSE.equals(plano.getAtivo())) {
            throw new RuntimeException("o plano já está inativo.");
        }

        plano.setAtivo(false);
        planoRepository.save(plano);
    }
}