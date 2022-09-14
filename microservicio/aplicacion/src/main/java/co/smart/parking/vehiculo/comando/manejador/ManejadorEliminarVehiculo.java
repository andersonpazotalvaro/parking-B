package co.smart.parking.vehiculo.comando.manejador;

import co.smart.parking.vehiculo.servicio.ServicioEliminarVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarVehiculo {

    private final ServicioEliminarVehiculo servicioEliminarVehiculo;

    public ManejadorEliminarVehiculo(ServicioEliminarVehiculo servicioEliminarVehiculo) {
        this.servicioEliminarVehiculo = servicioEliminarVehiculo;
    }

    public boolean ejecutar(String placa){
        return this.servicioEliminarVehiculo.ejecutar(placa);
    }
}
