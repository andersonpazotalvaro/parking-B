package co.smart.parking.vehiculo.comando.manejador;


import co.smart.parking.vehiculo.comando.RequestVehiculoTransaccion;
import co.smart.parking.vehiculo.comando.fabrica.FabricaVehiculo;
import co.smart.parking.vehiculo.servicio.ServicioActualizarVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCambiarEstadoVehiculo {

    private final ServicioActualizarVehiculo servicioActualizarVehiculo;
    private final FabricaVehiculo fabricaVehiculo;

    public ManejadorCambiarEstadoVehiculo(ServicioActualizarVehiculo servicioActualizarVehiculo, FabricaVehiculo fabricaVehiculo) {
        this.servicioActualizarVehiculo = servicioActualizarVehiculo;
        this.fabricaVehiculo = fabricaVehiculo;
    }

    public boolean ejecutar(RequestVehiculoTransaccion requestVehiculoTransaccion, boolean nuevoEstado){
        var vehiculo = this.fabricaVehiculo.crear(requestVehiculoTransaccion, nuevoEstado);
        return this.servicioActualizarVehiculo.ejecutar(vehiculo);
    }
}
