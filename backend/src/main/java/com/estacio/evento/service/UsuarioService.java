package com.estacio.evento.service;

import com.estacio.evento.dto.UsuarioDTO;
import com.estacio.evento.model.Usuario;

import java.util.List;

public interface UsuarioService {

    boolean autenticar(String email, String senha);

    Usuario salvarUsuario(UsuarioDTO usuarioDTO);

    Usuario save(Usuario usuario);

    void validarEmail(String email);

    List<UsuarioDTO> findAll();
}
