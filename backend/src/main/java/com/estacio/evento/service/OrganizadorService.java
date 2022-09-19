package com.estacio.evento.service;

import com.estacio.evento.model.Organizador;
import com.estacio.evento.repository.OrganizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizadorService {

    @Autowired
    private OrganizadorRepository organizadorRepository;

    public List<Organizador> findAll() {
        return organizadorRepository.findAll();
    }

    public Optional<Organizador> findById(Long id) {
        return organizadorRepository.findById(id);
    }

    @Transactional
    public Organizador save(Organizador organizador) {
        return organizadorRepository.save(organizador);
    }
}
