package com.estacio.evento.service;

import com.estacio.evento.exception.RegraNegocioException;
import com.estacio.evento.model.Usuario;
import com.estacio.evento.repository.UsuarioRepository;
import com.estacio.evento.service.impl.UsuarioServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
public class UsuarioServiceTest {

    private UsuarioService usuarioService; // spring boot procura a impl para da interface no container de injeção de dependencia
    
    private UsuarioRepository usuarioRepository;

    @Before("")
    public void setUp() {
        usuarioRepository = Mockito.mock(UsuarioRepository.class);
//        usuarioService = new UsuarioServiceImpl(usuarioRepository);
    }

    @Test
    public void deveValidarEmail() {
        // para validar e não retornar nenhum erro.
        Assertions.assertDoesNotThrow(() -> {

            UsuarioRepository usuarioRepositoryMock = Mockito.mock(UsuarioRepository.class);

            // cenario
            usuarioRepository.deleteAll();

            // acao
            usuarioService.validarEmail("email@email.com");
        });
    }

    @Test
    public void TestdeveLancarErroAoValidarEmailQuandoExistirEmailCadastrado() {
        Assertions.assertThrows(RegraNegocioException.class, () -> {
            // cenario
            Usuario usuario = Usuario.builder()
                    .email("email@email.com")
                    .senha("123")
                    .build();
            usuarioRepository.save(usuario);

            // acao
            usuarioService.validarEmail("email@email.com");
        });
    }
}
