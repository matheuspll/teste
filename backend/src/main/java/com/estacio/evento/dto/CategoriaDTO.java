package com.estacio.evento.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CategoriaDTO {

    @NotBlank
    private String name;
}
