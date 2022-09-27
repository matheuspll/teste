package com.estacio.evento.controller;

import com.estacio.evento.model.Organizador;
import com.estacio.evento.service.OrganizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "organizadores")
public class OrganizadorController {

    @Autowired
    private OrganizadorService organizadorService;

    @GetMapping
    public ResponseEntity<List<Organizador>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(organizadorService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Optional<Organizador> organizadorOptional = organizadorService.findById(id);
        if (!organizadorOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Organizador não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(organizadorOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOrganizador(@PathVariable(value = "id") Long id) {
        Optional<Organizador> organizadorOptional = organizadorService.findById(id);
        if (!organizadorOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Organizador não foi enconrtado");
        }
        organizadorService.delete(organizadorOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Organizador deletado com sucesso!");
    }
}
