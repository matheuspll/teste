package com.estacio.evento.service;

import com.estacio.evento.model.Curso;
import com.estacio.evento.model.Perfil;
import com.estacio.evento.repository.CursoRepository;
import com.estacio.evento.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public List<Perfil> findAll() {
        return perfilRepository.findAll();
    }

    public Optional<Perfil> findById(Long id) {
        return perfilRepository.findById(id);
    }

    @Transactional
    public Perfil save(Perfil perfil) {
        return perfilRepository.save(perfil);
    }
}
