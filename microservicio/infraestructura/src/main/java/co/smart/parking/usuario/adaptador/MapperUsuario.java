package co.smart.parking.usuario.adaptador;

import co.smart.parking.rol.adaptador.MapperRol;
import co.smart.parking.usuario.adaptador.entidad.EntidadUsuario;
import co.smart.parking.usuario.modelo.dominio.Usuario;
import co.smart.parking.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MapperUsuario {

    private final PasswordEncoder passwordEncoder;
    private final MapperRol mapperRol;

    public MapperUsuario(@Lazy PasswordEncoder passwordEncoder, MapperRol mapperRol) {
        this.passwordEncoder = passwordEncoder;
        this.mapperRol = mapperRol;
    }

    public RespuestaUsuario crearRespuesta(EntidadUsuario entidadUsuario) {
        return new RespuestaUsuario(
                entidadUsuario.getNombreUsuario(),
                entidadUsuario.getContrasena(),
                this.mapperRol.crearRespuestas(entidadUsuario.getRoles())
        );
    }

    public EntidadUsuario crearEntidad(Usuario usuario) {
        return new EntidadUsuario(
                usuario.getNombreUsuario(),
                passwordEncoder.encode(usuario.getContrasena()),
                this.mapperRol.crearEntidades(usuario.getRoles())
        );
    }

}
