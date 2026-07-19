package br.com.ifba.academia.usuario.controller;

import br.com.ifba.academia.usuario.entity.Usuario;
import br.com.ifba.academia.usuario.service.UsuarioIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class UsuarioController implements UsuarioIController {

    @Autowired
    private UsuarioIService usuarioService;

    @Override
    public Usuario save(Usuario usuario) { return usuarioService.save(usuario); }

    @Override
    public Usuario update(Usuario usuario) { return usuarioService.update(usuario); }

    @Override
    public void delete(Long id) { usuarioService.delete(id); }

    @Override
    public List<Usuario> findAll() { return usuarioService.findAll(); }

    @Override
    public Usuario findById(Long id) { return usuarioService.findById(id); }

    @Override
    public Usuario autenticar(String login, String senha) { return usuarioService.autenticar(login, senha); }
}