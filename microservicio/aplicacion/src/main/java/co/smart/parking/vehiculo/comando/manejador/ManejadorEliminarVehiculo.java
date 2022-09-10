package co.smart.parking.vehiculo.comando.manejador;

import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoEliminar;
import co.smart.parking.vehiculo.servicio.ServicioEliminarVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarVehiculo {

    private final ServicioEliminarVehiculo servicioEliminarVehiculo;

    public ManejadorEliminarVehiculo(ServicioEliminarVehiculo servicioEliminarVehiculo) {
        this.servicioEliminarVehiculo = servicioEliminarVehiculo;
    }

    public ResponseVehiculoEliminar ejecutar(Long id){
        this.servicioEliminarVehiculo.ejecutar(id);
        return new ResponseVehiculoEliminar("se elimino correctamente", id);
    }
}
