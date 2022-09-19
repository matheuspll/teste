package com.estacio.evento.service;

import com.estacio.evento.model.Atividade;
import com.estacio.evento.model.Curso;
import com.estacio.evento.repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    public List<Atividade> findAll() {
        return atividadeRepository.findAll();
    }

    public Optional<Atividade> findById(Long id) {
        return atividadeRepository.findById(id);
    }

    @Transactional
    public Atividade save(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }
}
