package com.estacio.evento.controller;

import com.estacio.evento.dto.UsuarioDTO;
import com.estacio.evento.exception.ErroAutenticacao;
import com.estacio.evento.exception.RegraNegocioException;
import com.estacio.evento.model.Usuario;
import com.estacio.evento.repository.UsuarioRepository;
import com.estacio.evento.service.UsuarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salvarUsuario(usuarioDTO));

        } catch (RegraNegocioException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PostMapping("/autenticar")
    public ResponseEntity<String> autenticar(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        try {
            if (usuarioService.autenticar(usuarioDTO.getEmailUser(), usuarioDTO.getPass())) {
                return ResponseEntity.status(HttpStatus.OK).body("Autenticado com sucesso!");
            }
        } catch (ErroAutenticacao e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.badRequest().build(); // retornar apenas uma badquirest() sem mensagem.
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (!usuarioOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não foi encontrado");
        }

        usuarioRepository.delete(usuarioOptional.get());
        return ResponseEntity.ok().body("deletado com sucesso!");
    }
}
