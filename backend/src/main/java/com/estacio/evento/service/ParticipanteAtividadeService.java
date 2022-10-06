package com.estacio.evento.service;

import com.estacio.evento.model.ParticipanteAtividade;
import com.estacio.evento.repository.ParticipanteAtividadeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ParticipanteAtividadeService {

    private final ParticipanteAtividadeRepository repository;
    

    // não há necessidade de autowired, pois o @Service já torna um bean gerenciado
    public ParticipanteAtividadeService(ParticipanteAtividadeRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ParticipanteAtividade save(ParticipanteAtividade participanteAtividade) {
        return repository.save(participanteAtividade);
    }

    public List<ParticipanteAtividade> findAll() {
        return repository.findAll();
    }

    public List<ParticipanteAtividade> findByIdParticipanteId(Long id) {
        return repository.findByIdParticipanteId(id);
    }

//    public Optional<ParticipanteAtividade> findById(Long id) {
//        return repository.findById(id);
//    }

    @Transactional
    public void delete(ParticipanteAtividade participanteAtividade) {
        repository.delete(participanteAtividade);
    }
}
