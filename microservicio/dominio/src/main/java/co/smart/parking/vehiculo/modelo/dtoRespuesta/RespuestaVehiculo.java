package co.smart.parking.vehiculo.modelo.dtoRespuesta;

import co.smart.parking.usuario.modelo.dtoRespuesta.RespuestaUsuarioPerfil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaVehiculo {

    private RespuestaUsuarioPerfil respuestaUsuarioPerfil;
    private String placa;
    private boolean activo;
}
