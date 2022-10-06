package com.estacio.evento.repository;

import com.estacio.evento.model.Participante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
    boolean existsByMatricula(Integer matricula);
    boolean existsByTelefone(String telefone);

    Optional<Participante> findByEmail(String email);
}
