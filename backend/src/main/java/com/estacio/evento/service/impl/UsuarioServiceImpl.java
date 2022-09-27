package com.estacio.evento.service.impl;

import com.estacio.evento.dto.UsuarioDTO;
import com.estacio.evento.exception.ErroAutenticacao;
import com.estacio.evento.exception.RegraNegocioException;
import com.estacio.evento.mapper.UsuarioMapper;
import com.estacio.evento.model.Usuario;
import com.estacio.evento.repository.UsuarioRepository;
import com.estacio.evento.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioMapper usuarioMapper;

    @Override
    public boolean autenticar(String email, String senha) {

        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (!usuario.isPresent()) {
            throw new ErroAutenticacao("Usuário não encontrado para o email informado.");
        }

        if (!usuario.get().getSenha().equals(senha)) {
            throw new ErroAutenticacao("Senha inválida.");
        }

        return true;
    }

    @Override
    @Transactional
    public Usuario salvarUsuario(UsuarioDTO usuarioDTO) {
        // garantindo que não existe um outro usuário já cadastrado
        Usuario usuario = usuarioMapper.usuarioDTOParaUsuario(usuarioDTO);
        validarEmail(usuario.getEmail());
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public Usuario save(Usuario usuario) {
        validarEmail(usuario.getEmail());
        return usuarioRepository.save(usuario);
    }

    @Override
    public void validarEmail(String email) {
        boolean existe = usuarioRepository.existsByEmail(email);
        if (existe) {
            throw new RegraNegocioException("Já existe um usuário cadastrado com este email");
        }
    }

    public List<UsuarioDTO> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarioMapper.paraUsuariosDTO(usuarios);
    }
}
