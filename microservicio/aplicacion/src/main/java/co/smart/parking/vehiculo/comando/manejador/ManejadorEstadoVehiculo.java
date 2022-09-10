package co.smart.parking.vehiculo.comando.manejador;

import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoCambiarEstado;
import co.smart.parking.vehiculo.servicio.ServicioCambiarEstadoVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEstadoVehiculo {

    private final ServicioCambiarEstadoVehiculo servicioCambiarEstadoVehiculo;


    public ManejadorEstadoVehiculo(ServicioCambiarEstadoVehiculo servicioCambiarEstadoVehiculo) {
        this.servicioCambiarEstadoVehiculo = servicioCambiarEstadoVehiculo;
    }

    public ResponseVehiculoCambiarEstado ejecutar(String placa){
       return this.servicioCambiarEstadoVehiculo.ejecutar(placa);
    }
}
