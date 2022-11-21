package co.smart.parking.usuario.puerto.dao;

import co.smart.parking.usuario.modelo.dtoRespuesta.RespuestaUsuarioPerfil;

public interface DaoUsuarioPerfil {

    RespuestaUsuarioPerfil obtenerUsuarioPorNombreDeUsuario(String nombreUsuario);
}
