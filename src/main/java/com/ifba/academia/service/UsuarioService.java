package com.ifba.academia.service;

import com.ifba.academia.model.Usuario;
import com.ifba.academia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 *
 * @author evandro
 */
@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository repository;

    public Usuario autenticar(String login, String senha) {
        // Usa o repositório para procurar um usuário que tenha exatamente esse login e senha
        Optional<Usuario> usuarioEncontrado = repository.findByLoginAndSenha(login, senha);
        
        // Se encontrar devolve Usuario, Se não achar devolve nulo.
        return usuarioEncontrado.orElse(null);
    }
    
}
