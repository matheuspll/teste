package com.estacio.evento.service;

import com.estacio.evento.model.Aluno;
import com.estacio.evento.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> findById(Long id) {
        return alunoRepository.findById(id);
    }

    @Transactional
    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

}
