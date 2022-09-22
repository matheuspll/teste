package com.estacio.evento.mapper;

import com.estacio.evento.dto.CategoriaDTO;
import com.estacio.evento.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    @Mapping(source = "name", target = "nome")

    Categoria categoriaDTOParaCategoria(CategoriaDTO categoriaDTO);

    @Mapping(source = "nome", target = "name")

    CategoriaDTO categoriaParaCategoriaDTO(Categoria categoria);

    List<CategoriaDTO> paraCategoriasDTO(List<Categoria> categorias);
}
