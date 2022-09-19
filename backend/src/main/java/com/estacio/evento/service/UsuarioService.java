package com.estacio.evento.service;

import com.estacio.evento.model.Usuario;

public interface UsuarioService {

    Usuario autenticar(String email);

    Usuario salvarUsuario(Usuario usuario);

    void validarEmail(String email);

}
