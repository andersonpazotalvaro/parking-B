package co.smart.parking.auth.adaptador;

import co.smart.parking.auth.adaptador.model.UsuarioDetalle;
import co.smart.parking.rol.adaptador.MapperRol;
import co.smart.parking.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import org.springframework.stereotype.Component;

@Component
public class MapperUsuarioDetalles {

    private final MapperRol mapperRol;

    public MapperUsuarioDetalles(MapperRol mapperRol) {
        this.mapperRol = mapperRol;
    }

    public UsuarioDetalle crearModelo(RespuestaUsuario respuestaUsuario) {
        return new UsuarioDetalle(
               respuestaUsuario.getNombreUsuario(),
               respuestaUsuario.getContrasena(),
               this.mapperRol.crearAutoridades(respuestaUsuario.getRoles())
        );
    }
}
