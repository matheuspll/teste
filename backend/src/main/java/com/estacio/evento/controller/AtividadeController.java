package com.estacio.evento.controller;

import com.estacio.evento.exception.RegraNegocioException;
import com.estacio.evento.model.Atividade;
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
        return ResponseEntity.status(HttpStatus.OK).body(atividadeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Atividade atividade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(atividadeService.save(atividade));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deletarAtividade(@PathVariable(value = "id") Long id) {
        Atividade atividade = atividadeService.findById(id);
        atividadeService.delete(atividade);
        return ResponseEntity.status(HttpStatus.OK).body("Atividade deletada com sucesso");
    }
}
