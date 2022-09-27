package com.estacio.evento.service;

import com.estacio.evento.model.Participante;
import com.estacio.evento.model.Periodo;
import com.estacio.evento.repository.ParticipanteRepository;
import com.estacio.evento.repository.PeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PeriodoService {

    @Autowired
    private PeriodoRepository periodoRepository;

    public List<Periodo> findAll() {
        return periodoRepository.findAll();
    }

    public Optional<Periodo> findById(Long id) {
        return periodoRepository.findById(id);
    }

    @Transactional
    public Periodo save(Periodo periodo) {
        return periodoRepository.save(periodo);
    }

    public void delete(Periodo periodo) {
        periodoRepository.delete(periodo);
    }
}
