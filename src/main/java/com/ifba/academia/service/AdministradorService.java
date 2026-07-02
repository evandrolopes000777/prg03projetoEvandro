package com.ifba.academia.service;

import com.ifba.academia.model.Administrador;
import com.ifba.academia.repository.AdministradorRepository;
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
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Transactional
    public Administrador salvar(Administrador administrador) {
        administrador.setPerfil("ADMIN");
        return administradorRepository.save(administrador);
    }

    public List<Administrador> listarTodos() {
        return administradorRepository.findAll();
    }

    public Optional<Administrador> buscarPorId(Long id) {
        return administradorRepository.findById(id);
    }

    public Optional<Administrador> autenticar(String login, String senha) {
        Optional<Administrador> adminOpt = administradorRepository.findByLogin(login);
        
        if (adminOpt.isPresent()) {
            Administrador admin = adminOpt.get();
            if (admin.getSenha().equals(senha)) {
                return Optional.of(admin);
            }
        }
        
        return Optional.empty();
    }

    @Transactional
    public void excluir(Long id) {
        try {
            administradorRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Não é possível excluir este administrador devido a vínculos existentes no banco de dados.");
        }
    }
}
