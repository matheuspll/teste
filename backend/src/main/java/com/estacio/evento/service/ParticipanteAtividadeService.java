package com.estacio.evento.service;

import com.estacio.evento.exception.ErroAutenticacao;
import com.estacio.evento.exception.RegraNegocioException;
import com.estacio.evento.model.ParticipanteAtividade;
import com.estacio.evento.repository.ParticipanteAtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipanteAtividadeService {

    @Autowired
    private ParticipanteAtividadeRepository participanteAtividadeRepository;

    @Transactional
    public ParticipanteAtividade save(ParticipanteAtividade participanteAtividade) {
        return participanteAtividadeRepository.save(participanteAtividade);
    }

    public List<ParticipanteAtividade> findAll() {
        return participanteAtividadeRepository.findAll();
    }

    public List<ParticipanteAtividade> findByIdParticipanteId(Long id) {
        return participanteAtividadeRepository.findByIdParticipanteId(id);
    }

//    public Optional<ParticipanteAtividade> findById(Long id) {
//        return participanteAtividadeRepository.findById(id);
//    }

    @Transactional
    public void delete(ParticipanteAtividade participanteAtividade) {
        participanteAtividadeRepository.delete(participanteAtividade);
    }
}
