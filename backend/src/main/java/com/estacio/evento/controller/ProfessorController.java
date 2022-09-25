package com.estacio.evento.controller;

import com.estacio.evento.model.Professor;
import com.estacio.evento.service.ProfessorService;
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
@RequestMapping(value = "professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<Professor>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(professorService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Optional<Professor> professorOptional = professorService.findById(id);
        if (!professorOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(professorOptional.get());
    }
}
