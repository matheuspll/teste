package com.estacio.evento.service;

import com.estacio.evento.exception.RegraNegocioException;
import com.estacio.evento.model.Curso;
import com.estacio.evento.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Curso findById(Long id) {
        return cursoRepository.findById(id).orElseThrow(
                () -> {
                    throw new RegraNegocioException("Este curso não existe");
                }
        );
    }

    @Transactional
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }
}
