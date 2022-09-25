package com.estacio.evento.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UsuarioDTO {

    @NotBlank
    private String emailUser;
    @NotBlank
    private String pass;
}
