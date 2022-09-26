package com.estacio.evento.config;

import com.estacio.evento.model.Categoria;

import java.util.ArrayList;
import java.util.List;

public class TestConfig {
    public static void main(String[] args) {

        Categoria categoria = new Categoria();
        categoria.setId(null);
        categoria.setNome("TI");

        List<Categoria> categorias = new ArrayList<>();
        categorias.add(categoria);

        boolean categoria1t = categorias.remove(categoria);


    }
}
