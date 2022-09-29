package co.smart.parking.usuario.adaptador;

import co.smart.parking.rol.adaptador.MapperRol;
import co.smart.parking.usuario.adaptador.entidad.EntidadUsuario;
import co.smart.parking.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import org.springframework.stereotype.Component;

@Component
public class MapperUsuario {

    private final MapperRol mapperRol;

    public MapperUsuario(MapperRol mapperRol) {
        this.mapperRol = mapperRol;
    }

    public RespuestaUsuario crearRespuesta(EntidadUsuario entidadUsuario) {
        return new RespuestaUsuario(
                entidadUsuario.getNombreUsuario(),
                entidadUsuario.getContrasena(),
                this.mapperRol.crearRespuestas(entidadUsuario.getRoles())
        );
    }
}
