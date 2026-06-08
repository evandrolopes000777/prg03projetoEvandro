package com.ifba.academia.controller;

import com.ifba.academia.model.Aluno;
import com.ifba.academia.service.AlunoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author evandro
 */
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    // CREATE: Cadastrar um novo aluno
    @PostMapping
    public ResponseEntity<Aluno> salvar(@RequestBody Aluno aluno) {
        Aluno novoAluno = service.salvar(aluno);
        return new ResponseEntity<>(novoAluno, HttpStatus.CREATED);
    }

    // READ: Listar todos os alunos cadastrados
    @GetMapping
    public ResponseEntity<List<Aluno>> listarTodos() {
        List<Aluno> alunos = service.listarTodos();
        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }

    // READ: Buscar um aluno específico pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        Optional<Aluno> aluno = service.buscarPorId(id);
        if (aluno.isPresent()) {
            return new ResponseEntity<>(aluno.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE: Apagar um aluno
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
