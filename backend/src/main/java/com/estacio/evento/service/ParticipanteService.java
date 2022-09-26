package com.estacio.evento.service;

import com.estacio.evento.model.Participante;
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

    public List<Participante> findAll() {
        return participanteRepository.findAll();
    }

    public Optional<Participante> findById(Long id) {
        return participanteRepository.findById(id);
    }

    @Transactional
    public Participante save(Participante participante) {
        cursoService.save(participante.getCurso());
        return participanteRepository.save(participante);
    }

    @Transactional
    public void delete(Participante participante) {
        participanteRepository.delete(participante);
    }

}
