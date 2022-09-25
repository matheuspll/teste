package com.estacio.evento.model.enums;

public enum AlunoStatus {

    CADASTRADO(1),
    CONFIRMADO(2);

    private final int code;

    AlunoStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static AlunoStatus valueOf(int code) {
        for (AlunoStatus value : AlunoStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid AlunoStatus code");
    }
}
