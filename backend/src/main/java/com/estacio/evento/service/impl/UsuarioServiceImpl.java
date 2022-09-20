package com.estacio.evento.service.impl;

import com.estacio.evento.exception.RegraDeNegocioException;
import com.estacio.evento.model.Usuario;
import com.estacio.evento.repository.UsuarioRepository;
import com.estacio.evento.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario autenticar(String email) {
        return null;
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public void validarEmail(String email) {
        boolean existe = usuarioRepository.existsByEmail(email);
        if (existe) {
            throw new RegraDeNegocioException("Já existe um usuário cadastrado com este email");
        }
    }
}
