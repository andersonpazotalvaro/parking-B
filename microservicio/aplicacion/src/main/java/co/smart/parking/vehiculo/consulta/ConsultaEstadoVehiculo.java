package co.smart.parking.vehiculo.consulta;

import co.smart.parking.vehiculo.servicio.ServicioObtenerEstadoVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ConsultaEstadoVehiculo {

    private final ServicioObtenerEstadoVehiculo servicioObtenerEstadoVehiculo;

    public ConsultaEstadoVehiculo(ServicioObtenerEstadoVehiculo servicioObtenerEstadoVehiculo) {
        this.servicioObtenerEstadoVehiculo = servicioObtenerEstadoVehiculo;
    }

    public boolean ejecutar(String vehiculoPlaca) {
        return this.servicioObtenerEstadoVehiculo.ejecutar(vehiculoPlaca);
    }
}
