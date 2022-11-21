package co.smart.parking.usuario.adaptador;

import co.smart.parking.rol.adaptador.MapperRol;
import co.smart.parking.usuario.adaptador.entidad.EntidadUsuarioPerfil;
import co.smart.parking.usuario.modelo.dominio.UsuarioPerfil;
import co.smart.parking.usuario.modelo.dtoRespuesta.RespuestaUsuarioPerfil;
import co.smart.parking.vehiculo.adaptador.MapperVehiculo;
import org.springframework.stereotype.Component;

@Component
public class MapperUsuarioPerfil {

    private final MapperRol mapperRol;
    private final MapperVehiculo mapperVehiculo;
    private final MapperUsuario mapperUsuario;

    public MapperUsuarioPerfil(MapperRol mapperRol, MapperVehiculo mapperVehiculo, MapperUsuario mapperUsuario) {
        this.mapperRol = mapperRol;
        this.mapperVehiculo = mapperVehiculo;
        this.mapperUsuario = mapperUsuario;
    }

    public RespuestaUsuarioPerfil crearRespuesta(EntidadUsuarioPerfil entidadUsuarioPerfil) {
        return new RespuestaUsuarioPerfil(
                entidadUsuarioPerfil.getUsuario().getNombreUsuario(),
                this.mapperRol.crearRespuestas(entidadUsuarioPerfil.getUsuario().getRoles()),
                this.mapperVehiculo.crearRespuestas(entidadUsuarioPerfil.getVehiculos())
        );
    }

    public EntidadUsuarioPerfil crearEntidad(UsuarioPerfil usuario) {
        return new EntidadUsuarioPerfil(
                this.mapperUsuario.crearEntidad(usuario.getUsuario()),
                this.mapperVehiculo.crearEntidades(usuario.getVehiculos())
        );
    }

}
