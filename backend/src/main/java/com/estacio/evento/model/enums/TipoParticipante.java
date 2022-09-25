package com.estacio.evento.model.enums;

public enum TipoParticipante {

    OUVINTE(1),
    PALESTRANTE(2);

    private final int code;

    TipoParticipante(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TipoParticipante valueOf(int code) {
        for (TipoParticipante value : TipoParticipante.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TipoParticipant code");
    }
}
