package co.smart.parking.vehiculo.modelo.dtoRespuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVehiculoEliminar {

    private String mensaje;

    private Long id;

}
