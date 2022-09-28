package com.estacio.evento.mapper;

import com.estacio.evento.dto.UsuarioDTO;
import com.estacio.evento.model.Participante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ParticipanteMapper {

    @Mapping(source = "name", target = "nome")
    @Mapping(source = "emailUser", target = "email")
    @Mapping(source = "pass", target = "senha")

    Participante participanteDtoParaUsuario(ParticipanteDTO usuarioDTO);

    @Mapping(source = "nome", target = "name")
    @Mapping(source = "email", target = "emailUser")
    @Mapping(source = "senha", target = "pass")
    UsuarioDTO usuarioParaUsuarioDTO(Usuario usuario);

    List<UsuarioDTO> paraUsuariosDTO(List<Usuario> usuarios);
}
