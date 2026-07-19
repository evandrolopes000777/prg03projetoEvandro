package br.com.ifba.academia.usuario.service;

import br.com.ifba.academia.usuario.entity.Usuario;
import br.com.ifba.academia.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements UsuarioIService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario save(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Os dados do usuario nao podem ser nulos");
        }
        if (usuario.getId() != null) {
            throw new IllegalArgumentException("O ID do usuario deve ser nulo");
        }
        if (usuario.getLogin() == null || usuario.getLogin().isBlank()) {
            throw new IllegalArgumentException("O campo login e obrigatorio");
        }
        if (usuario.getSenha() == null || usuario.getSenha().isBlank()) {
            throw new IllegalArgumentException("O campo senha e obrigatorio");
        }
        if (usuario.getPerfil() == null || (!usuario.getPerfil().equalsIgnoreCase("ADMIN") && !usuario.getPerfil().equalsIgnoreCase("ALUNO"))) {
            throw new IllegalArgumentException("O perfil do usuario deve ser obrigatoriamente 'ADMIN' ou 'ALUNO'");
        }
        if (usuario.getPessoa() == null || usuario.getPessoa().getId() == null) {
            throw new IllegalArgumentException("O usuario deve estar vinculado a uma pessoa previamente cadastrada no sistema");
        }
        if (usuarioRepository.existsByLogin(usuario.getLogin())) {
            throw new RuntimeException("Ja existe um usuario cadastrado com este login");
        }

        usuario.setAtivo(true);
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Os dados do usuario nao podem ser nulos");
        }
        if (usuario.getId() == null) {
            throw new IllegalArgumentException("O ID e obrigatorio para atualizar o usuario");
        }
        if (!usuarioRepository.existsById(usuario.getId())) {
            throw new RuntimeException("Usuario nao encontrado");
        }

        return usuarioRepository.save(usuario);
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID nao pode ser nulo para remocao");
        }

        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));

        if (!usuario.getAtivo()) {
            throw new RuntimeException("Este usuario ja consta como desativado no sistema");
        }

        usuario.setAtivo(false);
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID nao pode ser nulo");
        }

        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findByAtivoTrue();
    }

    @Override
    public Usuario autenticar(String login, String senha) {
        if (login == null || login.isBlank()) {
            throw new IllegalArgumentException("O login deve ser informado para entrar no sistema");
        }
        if (senha == null || senha.isBlank()) {
            throw new IllegalArgumentException("A senha deve ser informada para entrar no sistema");
        }

        Optional<Usuario> usuarioOpt = usuarioRepository.findByLogin(login);

        if (usuarioOpt.isEmpty()) {
            throw new RuntimeException("Credenciais invalidas, Usuario nao encontrado");
        }

        Usuario usuario = usuarioOpt.get();

        if (!usuario.getAtivo()) {
            throw new RuntimeException("Acesso negado: Este usuario esta inativo ou bloqueado.");
        }
        if (!usuario.getSenha().equals(senha)) {
            throw new RuntimeException("Credenciais invalidas, Senha incorreta");
        }

        return usuario;
    }
}