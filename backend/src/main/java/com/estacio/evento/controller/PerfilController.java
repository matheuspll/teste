package com.estacio.evento.controller;

import com.estacio.evento.model.Perfil;
import com.estacio.evento.service.PerfilService;
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
@RequestMapping(value = "/perfis")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public ResponseEntity<List<Perfil>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(perfilService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {

        Optional<Perfil> optionalPerfil = perfilService.findById(id);
        if (!optionalPerfil.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Perfil não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(optionalPerfil.get());
    }

}
