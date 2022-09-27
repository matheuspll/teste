package com.estacio.evento.controller;

import com.estacio.evento.model.Atividade;
import com.estacio.evento.model.Organizador;
import com.estacio.evento.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/atividades")
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @GetMapping
    public ResponseEntity<List<Atividade>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(atividadeService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Optional<Atividade> atividadeOptional = atividadeService.findById(id);
        if (!atividadeOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atividade não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(atividadeOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAtividade(@PathVariable(value = "id") Long id) {
        Optional<Atividade> atividadeOptional = atividadeService.findById(id);
        if (!atividadeOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atividade não foi encontrada");
        }
        atividadeService.delete(atividadeOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Atividade deletada com sucesso!");
    }
}
