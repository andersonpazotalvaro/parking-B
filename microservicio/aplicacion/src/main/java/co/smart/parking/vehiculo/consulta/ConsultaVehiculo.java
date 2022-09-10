package co.smart.parking.vehiculo.consulta;

import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoConsultar;
import co.smart.parking.vehiculo.servicio.ServicioConsultarVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ConsultaVehiculo {
    private final ServicioConsultarVehiculo servicioConsultarVehiculo;

    public ConsultaVehiculo(ServicioConsultarVehiculo servicioConsultarVehiculo) {
        this.servicioConsultarVehiculo = servicioConsultarVehiculo;
    }

    public ResponseVehiculoConsultar ejecutar(Long id){
       return this.servicioConsultarVehiculo.ejecutar(id);
    }
}
