package br.com.ifba.academia.usuario.service;

import br.com.ifba.academia.usuario.entity.Usuario;
import java.util.List;

public interface UsuarioIService {
    
    Usuario findById(Long id);
    
    List<Usuario> findAll();
    
    Usuario autenticar(String login, String senha);
    
    void delete(Long id);
    
    Usuario save(Usuario usuario);
        
    Usuario update(Usuario usuario);
    
}