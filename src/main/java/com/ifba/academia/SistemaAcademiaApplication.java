package com.ifba.academia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SistemaAcademiaApplication {

    public static void main(String[] args) {
        
        System.setProperty("java.awt.headless", "false");
        
        ApplicationContext context = SpringApplication.run(SistemaAcademiaApplication.class, args);
        
        com.ifba.academia.service.AlunoService alunoService = context.getBean(com.ifba.academia.service.AlunoService.class);
        
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
            new com.ifba.academia.view.Dashboard(alunoService).setVisible(true);
        });
    }
}