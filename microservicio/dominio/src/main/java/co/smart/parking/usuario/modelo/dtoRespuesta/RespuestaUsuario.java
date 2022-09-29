package co.smart.parking.usuario.modelo.dtoRespuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaUsuario {

    private String nombreUsuario;
    private String contrasena;
    private Set<String> roles;
}
