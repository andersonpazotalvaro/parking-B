package co.smart.parking.usuario.puerto;

import co.smart.parking.usuario.modelo.dtoRespuesta.RespuestaUsuario;

public interface DaoUsuario {

    RespuestaUsuario obtenerUsuarioPorNombreDeUsuario(String nombreUsuario);
}
