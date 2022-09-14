package co.smart.parking.vehiculo.comando.manejador;

import co.smart.parking.vehiculo.comando.RequestVehiculoTransaccion;
import co.smart.parking.vehiculo.comando.fabrica.FabricaVehiculo;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.RespuestaVehiculo;
import co.smart.parking.vehiculo.servicio.ServicioGuardarVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorGuardarVehiculo {

    private final FabricaVehiculo fabricaVehiculo;

    private final ServicioGuardarVehiculo servicioGuardarVehiculo;

    public ManejadorGuardarVehiculo(FabricaVehiculo fabricaVehiculo, ServicioGuardarVehiculo servicioGuardarVehiculo) {
        this.fabricaVehiculo = fabricaVehiculo;
        this.servicioGuardarVehiculo = servicioGuardarVehiculo;
    }

    public RespuestaVehiculo ejecutar(RequestVehiculoTransaccion requestVehiculoTransaccion) {
        var vehiculo = this.fabricaVehiculo.crear(requestVehiculoTransaccion, true);
        return this.servicioGuardarVehiculo.ejecutar(vehiculo);
    }

}
