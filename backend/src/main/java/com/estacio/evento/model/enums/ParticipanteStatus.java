package com.estacio.evento.model.enums;

public enum ParticipanteStatus {

    CADASTRADO(1),
    CONFIRMADO(2);

    private final int code;

    ParticipanteStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ParticipanteStatus valueOf(int code) {
        for (ParticipanteStatus value : ParticipanteStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid ParticipanteStatus code");
    }
}
