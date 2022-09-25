package com.estacio.evento.controller;

import com.estacio.evento.model.Aluno;
import com.estacio.evento.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Optional<Aluno> alunoOptional = alunoService.findById(id);

        if (!alunoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não foi encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(alunoOptional.get());
    }

}
