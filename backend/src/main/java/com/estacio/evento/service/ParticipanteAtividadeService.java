package com.estacio.evento.service;

import com.estacio.evento.exception.RegraNegocioException;
import com.estacio.evento.model.Atividade;
import com.estacio.evento.model.Participante;
import com.estacio.evento.model.ParticipanteAtividade;
import com.estacio.evento.model.enums.StatusParticipacao;
import com.estacio.evento.repository.ParticipanteAtividadeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ParticipanteAtividadeService {

    private final ParticipanteAtividadeRepository repository;
    private final ParticipanteService participanteService;
    private final AtividadeService atividadeService;

    // não há necessidade de autowired, pois o @Service já torna um bean gerenciado
    public ParticipanteAtividadeService(ParticipanteAtividadeRepository repository, ParticipanteService participanteService, AtividadeService atividadeService) {
        this.repository = repository;
        this.participanteService = participanteService;
        this.atividadeService = atividadeService;
    }

    @Transactional
    public ParticipanteAtividade save(ParticipanteAtividade participanteAtividade) {

        Participante participante = participanteService.findById(participanteAtividade.getParticipante().getId());
        Atividade atividade = atividadeService.findById(participanteAtividade.getAtividade().getId());

        participanteAtividade.setParticipante(participante);
        participanteAtividade.setAtividade(atividade);
        participanteAtividade.setStatusParticipacao(StatusParticipacao.INSCRITO);
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
    public void deletarParticipante(Participante participante) {
        repository.deleteByIdParticipanteId(participante.getId());
    }

    @Transactional
    public void deletarParticipacao(ParticipanteAtividade participanteAtividade) {
        repository.delete(participanteAtividade);
    }

}
