package com.estacio.evento.controller;

import com.estacio.evento.model.Participante;
import com.estacio.evento.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/participantes")
public class ParticipanteController {

    @Autowired
    private ParticipanteService participanteService;

    @GetMapping
    public ResponseEntity<List<Participante>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(participanteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Optional<Participante> participanteOptional = participanteService.findById(id);

        if (!participanteOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Participante não foi encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(participanteOptional.get());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deletarParticipante(@PathVariable(value = "id") Long id) {
        Optional<Participante> participanteOptional = participanteService.findById(id);
        if (!participanteOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Participante não foi encontrada");
        }
        participanteService.delete(participanteOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Participante deletada com sucesso!");
    }
}
