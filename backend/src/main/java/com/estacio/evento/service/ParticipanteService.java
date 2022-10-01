package com.estacio.evento.service;

import com.estacio.evento.exception.ErroAutenticacao;
import com.estacio.evento.exception.RegraNegocioException;
import com.estacio.evento.model.Curso;
import com.estacio.evento.model.Participante;
import com.estacio.evento.model.Perfil;
import com.estacio.evento.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipanteRepository participanteRepository;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private PerfilService perfilService;

    public boolean autenticar(String email, String senha) {
        Optional<Participante> participante = participanteRepository.findByEmail(email);
        if (!participante.isPresent()) {
            throw new ErroAutenticacao("Usuário não encontrado para o email informado");
        }

        if (!participante.get().getSenha().equals(senha)) {
            throw new ErroAutenticacao("Senha inválida");
        }
        return true;
    }
    @Transactional
    public Participante salvarParticipante(Participante participante) {
        // garantindo que não exite um outro participante já cadastrado
        validarEmail(participante.getEmail());

        Optional<Curso> cursoOptional = cursoService.findById(participante.getCurso().getId());
        Optional<Perfil> perfilOptional = perfilService.findById(participante.getPerfil().getId());
        if (!cursoOptional.isPresent()) {
            throw new RegraNegocioException("Esse curso não existe");
        }
        if (!perfilOptional.isPresent()) {
            throw new RegraNegocioException("Esse perfil não existe");
        }
        participante.setCurso(cursoOptional.get());
        participante.setPerfil(perfilOptional.get());
        return participanteRepository.save(participante);
    }

    public void validarEmail(String email) {
        boolean existe = participanteRepository.existsByEmail(email);
        if (existe) {
            throw new RegraNegocioException("Já existe um participante cadastrado com este email");
        }
    }

    public List<Participante> findAll() {
        return participanteRepository.findAll();
    }

    public Optional<Participante> findById(Long id) {
        return participanteRepository.findById(id);
    }

    @Transactional
    public void delete(Participante participante) {
        participanteRepository.delete(participante);
    }
}
