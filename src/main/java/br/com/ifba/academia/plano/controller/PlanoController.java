package br.com.ifba.academia.plano.controller;

import br.com.ifba.academia.plano.entity.Plano;
import br.com.ifba.academia.plano.service.PlanoIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class PlanoController implements PlanoIController{
    
    @Autowired
    private PlanoIService planoService;

    @Override
    public Plano findById(Long id) {
        return planoService.findById(id);
    }

    @Override
    public List<Plano> findAll() {
        return planoService.findAll();
    }

    @Override
    public List<Plano> findByNome(String nome) {
        return planoService.findByNome(nome);
    }

    @Override
    public Plano save(Plano plano) {
        return planoService.save(plano);
    }

    @Override
    public Plano update(Plano plano) {
        return planoService.update(plano);
    }

    @Override
    public void delete(Long id) {
        planoService.delete(id);
    }
    
}
