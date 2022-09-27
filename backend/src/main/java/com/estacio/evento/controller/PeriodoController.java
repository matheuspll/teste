package com.estacio.evento.controller;

import com.estacio.evento.model.Periodo;
import com.estacio.evento.service.PeriodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/periodos")
public class PeriodoController {

    @Autowired
    private PeriodoService periodoService;

    @GetMapping
    public ResponseEntity<List<Periodo>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(periodoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {

        Optional<Periodo> periodoOptional = periodoService.findById(id);

        if (!periodoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Periodo não registrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(periodoOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePeriodo(@PathVariable(value = "id") Long id) {
        Optional<Periodo> periodoOptional = periodoService.findById(id);
        if (!periodoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Periodo não foi encontrada");
        }
        periodoService.delete(periodoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Periodo deletado com sucesso!");
    }
}
