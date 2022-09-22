package com.estacio.evento.service;

import com.estacio.evento.dto.UsuarioDTO;
import com.estacio.evento.model.Usuario;

import java.util.List;

public interface UsuarioService {

    boolean autenticar(String email, String senha);

    Usuario salvarUsuario(UsuarioDTO usuarioDTO);

    void validarEmail(String email);

    List<UsuarioDTO> findAll();

}
