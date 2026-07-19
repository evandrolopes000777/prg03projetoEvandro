package br.com.ifba.academia;

import br.com.ifba.academia.usuario.view.TelaLogin;
import br.com.ifba.academia.usuario.controller.UsuarioIController;
import br.com.ifba.academia.pessoa.controller.PessoaIController;
import br.com.ifba.academia.plano.controller.PlanoIController;
import br.com.ifba.academia.planoaluno.controller.PlanoAlunoIController;
import br.com.ifba.academia.fichatreino.controller.FichaTreinoIController;
import br.com.ifba.academia.exercicio.controller.ExercicioIController;

import br.com.ifba.academia.usuario.entity.Usuario;
import br.com.ifba.academia.pessoa.entity.Pessoa;
import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import javax.swing.SwingUtilities;

@SpringBootApplication
public class AcademiaApplication {

    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false");
        ApplicationContext context = SpringApplication.run(AcademiaApplication.class, args);

        UsuarioIController usuarioController = context.getBean(UsuarioIController.class);
        PessoaIController pessoaController = context.getBean(PessoaIController.class);
        PlanoIController planoController = context.getBean(PlanoIController.class);
        PlanoAlunoIController planoAlunoController = context.getBean(PlanoAlunoIController.class);
        FichaTreinoIController fichaTreinoController = context.getBean(FichaTreinoIController.class);
        ExercicioIController exercicioController = context.getBean(ExercicioIController.class);

        //verificar se o banco esta vazio, se sim, criar um admin padrao
        if (usuarioController.findAll().isEmpty()) {
            
            Pessoa adminPessoa = new Pessoa();
            adminPessoa.setNome("Administrador Padrão");
            adminPessoa.setCpf("00000000000");
            adminPessoa.setTelefone("00000000000");
            adminPessoa.setDataNascimento(LocalDate.now());
            adminPessoa = pessoaController.save(adminPessoa);

            Usuario adminUsuario = new Usuario();
            adminUsuario.setLogin("admin");
            adminUsuario.setSenha("admin");
            adminUsuario.setPerfil("ADMIN");
            adminUsuario.setPessoa(adminPessoa);
            usuarioController.save(adminUsuario);

            System.out.println("BANCO DE DADOS ZERADO DETECTADO!");
            System.out.println("Admin Padrão criado.");
            System.out.println("LOGIN: admin");
            System.out.println("SENHA: admin");
        }

        SwingUtilities.invokeLater(() -> {
            TelaLogin telaLogin = new TelaLogin(
                usuarioController,
                pessoaController,
                planoController,
                planoAlunoController,
                fichaTreinoController,
                exercicioController
            );
            telaLogin.setVisible(true);
        });
    }
}