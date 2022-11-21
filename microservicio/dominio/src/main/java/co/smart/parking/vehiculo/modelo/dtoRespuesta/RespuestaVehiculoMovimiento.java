package co.smart.parking.vehiculo.modelo.dtoRespuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaVehiculoMovimiento {

    private Long id;
    private String vehiculo;
    private String tipoMovimiento;
    private LocalDateTime fecha;
}
