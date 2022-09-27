package com.estacio.evento.config;

import com.estacio.evento.model.Categoria;
import com.estacio.evento.model.Endereco;

import java.util.ArrayList;
import java.util.List;

public class TestConfig {
    public static void main(String[] args) {


        Endereco endereco = new Endereco();

        endereco.setRua("isaura parente");

        System.out.println(endereco.getRua());

    }
}
