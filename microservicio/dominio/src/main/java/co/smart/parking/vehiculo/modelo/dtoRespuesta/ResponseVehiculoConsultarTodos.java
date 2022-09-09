package co.smart.parking.vehiculo.modelo.dtoRespuesta;

import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVehiculoConsultarTodos {

    private List<Vehiculo> vehiculos;

}
