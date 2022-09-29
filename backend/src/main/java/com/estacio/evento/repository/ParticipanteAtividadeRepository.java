package com.estacio.evento.repository;

import com.estacio.evento.model.Participante;
import com.estacio.evento.model.ParticipanteAtividade;
import com.estacio.evento.model.pk.ParticipanteAtividadePK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipanteAtividadeRepository extends JpaRepository<ParticipanteAtividade, ParticipanteAtividadePK> {
//    List<Book> findByIdName(String name);
//
//    List<Book> findByIdAuthor(String author);

    List<ParticipanteAtividade> findByIdParticipanteId(Long id);

//    void deleteByEmployeePK_FirstName(String firstName);
}
