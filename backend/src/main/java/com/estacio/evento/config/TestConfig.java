package com.estacio.evento.config;

import com.estacio.evento.model.Atividade;
import com.estacio.evento.model.Categoria;

public class TestConfig {
    public static void main(String[] args) {
        Atividade atividade = new Atividade();
        atividade.setTitulo("Curso de programação");
        atividade.setDescricao("programando java orientado a objetos");

        System.out.println(atividade.getTitulo());
        System.out.println(atividade.getDescricao());
        System.out.println(atividade.getCategoria());
    }
}
