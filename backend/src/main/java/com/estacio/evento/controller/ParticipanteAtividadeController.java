package com.estacio.evento.controller;

import com.estacio.evento.model.ParticipanteAtividade;
import com.estacio.evento.service.ParticipanteAtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/participacoes")
public class ParticipanteAtividadeController {

    @Autowired
    private ParticipanteAtividadeService participanteAtividadeService;

    @GetMapping
    public ResponseEntity<List<ParticipanteAtividade>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(participanteAtividadeService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<ParticipanteAtividade>> findByIdParticipanteId(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(participanteAtividadeService.findByIdParticipanteId(id));
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
//        Optional<ParticipanteAtividade> participanteAtividadeOptional = participanteAtividadeService.findById(id);
//
//        if (!participanteAtividadeOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ParticipanteAtividade não foi encontrado");
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(participanteAtividadeOptional.get());
//    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody ParticipanteAtividade participante) {
        return ResponseEntity.status(HttpStatus.OK).body(participanteAtividadeService.save(participante));
    }
//
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<Object> deleteParticipanteAtividade(@PathVariable(value = "id") Long id) {
//        Optional<ParticipanteAtividade> participanteAtividadeOptional = participanteAtividadeService.findById(id);
//        if (!participanteAtividadeOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ParticipanteAtividade não foi enconrtado");
//        }
//        participanteAtividadeService.delete(participanteAtividadeOptional.get());
//        return ResponseEntity.status(HttpStatus.OK).body("ParticipanteAtividade deletado com sucesso!");
//    }
}
