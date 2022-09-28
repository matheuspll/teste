package com.estacio.evento.model;

import com.estacio.evento.model.enums.StatusParticipacao;
import com.estacio.evento.model.pk.ParticipanteAtividadePK;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "TB_PARTICIPANTE_ATIVIDADE")
public class ParticipanteAtividade implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private final ParticipanteAtividadePK id = new ParticipanteAtividadePK();

    private Integer statusParticipacao;

    public ParticipanteAtividade() {
    }

    public ParticipanteAtividade(Participante participante, Atividade atividade, StatusParticipacao statusParticipacao) {
        id.setParticipante(participante);
        id.setAtividade(atividade);
        setStatusParticipacao(statusParticipacao);
    }

    public Participante getParticipante() {
        return id.getParticipante();
    }

    public void setParticipante(Participante participante) {
        id.setParticipante(participante);
    }

    public Atividade getAtividade() {
        return id.getAtividade();
    }

    public void setAtividade(Atividade atividade) {
        id.setAtividade(atividade);
    }

    public StatusParticipacao getStatusParticipacao() {
        return StatusParticipacao.valueOf(statusParticipacao);
    }

    public void setStatusParticipacao(StatusParticipacao statusParticipacao) {
        if (statusParticipacao != null) {
            this.statusParticipacao = statusParticipacao.getCode();
        }
    }

}
