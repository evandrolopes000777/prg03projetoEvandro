package com.ifba.academia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.ifba.academia.service.UsuarioService;
import com.ifba.academia.service.PlanoAlunoService;
import com.ifba.academia.service.FichaTreinoService;
import com.ifba.academia.view.TelaLogin;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.ifba.academia.repository")
public class SistemaAcademiaApplication {

    public static void main(String[] args) {
        
        System.setProperty("java.awt.headless", "false");
        
        ApplicationContext context = SpringApplication.run(SistemaAcademiaApplication.class, args);
        
        UsuarioService usuarioService = context.getBean(UsuarioService.class);
        PlanoAlunoService planoAlunoService = context.getBean(PlanoAlunoService.class);
        FichaTreinoService fichaTreinoService = context.getBean(FichaTreinoService.class);
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            System.err.println("Erro ao aplicar o tema visual.");
        }
        
        //Abre o JFrame
        java.awt.EventQueue.invokeLater(() -> {
            
            new TelaLogin(usuarioService, planoAlunoService, fichaTreinoService).setVisible(true);
            
        });
    }
}