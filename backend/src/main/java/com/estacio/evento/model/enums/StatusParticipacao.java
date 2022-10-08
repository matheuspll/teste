package com.estacio.evento.model.enums;

public enum StatusParticipacao {

    INSCRITO(1),
    PRESENTE(2),
    AUSENTE(3);

    private final int code;

    StatusParticipacao(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static StatusParticipacao valueOf(int code) {
        for (StatusParticipacao value : StatusParticipacao.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid ParticipacaoStatus code");
    }
}
