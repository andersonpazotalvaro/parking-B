package co.smart.parking.vehiculo.modelo.dtoRespuesta;

import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import lombok.Getter;

import java.util.List;

@Getter
public class ResponseVehiculoConsultar {

    private String mensaje;

    private List<Vehiculo> vehiculos;

}
