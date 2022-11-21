package co.smart.parking.usuario.comando.fabrica;


import co.smart.parking.usuario.comando.RequestUsuarioTransaccion;
import co.smart.parking.usuario.modelo.dominio.Usuario;
import co.smart.parking.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class FabricaUsuario {

    public Usuario crear(RequestUsuarioTransaccion requestUsuarioTransaccion) {
        return new Usuario(
                requestUsuarioTransaccion.getNombreUsuario(),
                requestUsuarioTransaccion.getContrasena(),
                requestUsuarioTransaccion.getRoles()
        );
    }

    public Usuario crear(RespuestaUsuario respuestaUsuario) {
        return new Usuario(
                respuestaUsuario.getNombreUsuario(),
                respuestaUsuario.getContrasena(),
                respuestaUsuario.getRoles()
        );
    }
}
