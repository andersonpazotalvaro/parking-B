package co.smart.parking.estudiante.modelo.dtoRespuesta;

import co.smart.parking.usuario.modelo.dtoRespuesta.RespuestaUsuarioPerfil;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.RespuestaVehiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaEstudiante extends RespuestaUsuarioPerfil {

    private Set<RespuestaVehiculo> respuestaVehiculos;
}
