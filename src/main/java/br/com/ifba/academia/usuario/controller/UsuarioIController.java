package br.com.ifba.academia.usuario.controller;

import br.com.ifba.academia.usuario.entity.Usuario;
import java.util.List;

public interface UsuarioIController {
    
    List<Usuario> findAll();
    
    Usuario findById(Long id);
    
    Usuario autenticar(String login, String senha);
    
    void delete(Long id);
    
    Usuario save(Usuario usuario);
    
    Usuario update(Usuario usuario);
}