package co.smart.parking.vehiculo.consulta;

import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoConsultarTodos;
import co.smart.parking.vehiculo.servicio.ServicioConsultarTodosVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ConsultaVehiculoTodos {

    private final ServicioConsultarTodosVehiculo servicioConsultarTodosVehiculo;

    public ConsultaVehiculoTodos(ServicioConsultarTodosVehiculo servicioConsultarTodosVehiculo) {
        this.servicioConsultarTodosVehiculo = servicioConsultarTodosVehiculo;
    }

    public ResponseVehiculoConsultarTodos ejecutar(){
       return this.servicioConsultarTodosVehiculo.ejecutar();
    }
}
