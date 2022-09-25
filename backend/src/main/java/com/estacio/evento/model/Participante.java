package com.estacio.evento.model;

import com.estacio.evento.model.enums.AlunoStatus;
import com.estacio.evento.model.enums.TipoParticipante;

public interface Participante {

    AlunoStatus getAlunoStatus();
    TipoParticipante getTipoParticipante();
    void setTipoParticipante(TipoParticipante tipoParticipante);
}
