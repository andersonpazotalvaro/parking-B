package co.smart.parking.vehiculo.modelo.dtoRespuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaVehiculo {

    private Long id;
    private String placa;
    private boolean activo;
}
