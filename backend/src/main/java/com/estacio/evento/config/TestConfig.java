package com.estacio.evento.config;

import com.estacio.evento.model.Atividade;
import com.estacio.evento.model.Categoria;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestConfig {
    public static void main(String[] args) {
//        Atividade atividade = new Atividade();
//        atividade.setTitulo("Curso de programação");
//        atividade.setDescricao("programando java orientado a objetos");
//
//        System.out.println(atividade.getTitulo());
//        System.out.println(atividade.getDescricao());
//        System.out.println(atividade.getCategoria());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println(LocalDateTime.parse("2022-09-10 19:30", formatter));
    }
}
