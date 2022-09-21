package com.estacio.evento.service;

import com.estacio.evento.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
public class UsuarioServiceTest {

    @Autowired
    private UsuarioService usuarioService; // spring boot procura a impl para da interface no container de injeção de dependencia

    @Autowired
    UsuarioRepository usuarioRepository;


    public void deveValidarEmail() {

    }
}
