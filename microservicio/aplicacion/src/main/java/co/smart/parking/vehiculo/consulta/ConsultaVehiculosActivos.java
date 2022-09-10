package co.smart.parking.vehiculo.consulta;

import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoConsultarTodos;
import co.smart.parking.vehiculo.servicio.ServicioConsultarActivosVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ConsultaVehiculosActivos {

    private final ServicioConsultarActivosVehiculo servicioConsultarActivosVehiculo;

    public ConsultaVehiculosActivos(ServicioConsultarActivosVehiculo servicioConsultarActivosVehiculo) {
        this.servicioConsultarActivosVehiculo = servicioConsultarActivosVehiculo;
    }

    public ResponseVehiculoConsultarTodos ejecutar(){
       return this.servicioConsultarActivosVehiculo.ejecutar();
    }
}
