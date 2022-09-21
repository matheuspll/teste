package com.estacio.evento.controller;

import com.estacio.evento.dto.UsuarioDTO;
import com.estacio.evento.model.Usuario;
import com.estacio.evento.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody UsuarioDTO usuarioDTO) {

        Usuario usuario = Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .build();

        try {
            Usuario usuarioSalvo = usuarioService.salvarUsuario(usuario);
        } catch (Exception e) {
            
        }
    }
}
