package com.estacio.evento.mapper;

import com.estacio.evento.dto.UsuarioDTO;
import com.estacio.evento.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(source = "name", target = "nome")
    @Mapping(source = "emailUser", target = "email")
    @Mapping(source = "pass", target = "senha")

    Usuario usuarioDTOParaUsuario(UsuarioDTO usuarioDTO);

    @Mapping(source = "nome", target = "name")
    @Mapping(source = "email", target = "emailUser")
    @Mapping(source = "senha", target = "pass")

    UsuarioDTO usuarioParaUsuarioDTO(Usuario usuario);

    List<UsuarioDTO> paraUsuariosDTO(List<Usuario> usuarios);
}
