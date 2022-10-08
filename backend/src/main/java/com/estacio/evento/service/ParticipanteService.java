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
        // garantindo que não exite um outro participante já cadastrado com as mesmos atributos
        validar(participante);

        Curso curso = cursoService.findById(participante.getCurso().getId());
        Perfil perfil = perfilService.findById(participante.getPerfil().getId());

        participante.setCurso(curso);
        participante.setPerfil(perfil);
        return participanteRepository.save(participante);
    }

    public void validar(Participante participante) {
        validarEmail(participante.getEmail());
        if (participanteRepository.existsByCpf(participante.getCpf())) {
            throw new RegraNegocioException("Já existe um participante cadastrado com este cpf");
        }

        if (participanteRepository.existsByTelefone(participante.getTelefone())) {
            throw new RegraNegocioException("Já existe um participante cadastrado com este telefone");
        }

        if (participante.getTelefone() != null) {
            if (participanteRepository.existsByMatricula(participante.getMatricula())) {
                throw new RegraNegocioException("Já existe um participante cadastrado com esta matricula");
            }
        }
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

    public Participante findById(Long id) {
        return participanteRepository.findById(id).orElseThrow(
                () -> new RegraNegocioException("Este participante não existe")
        );
    }

    @Transactional
    public void delete(Participante participante) {
        participanteRepository.delete(participante);
    }
}
