package co.smart.parking.vehiculo.consulta;

import co.smart.parking.vehiculo.modelo.dtoRespuesta.RespuestaVehiculo;
import co.smart.parking.vehiculo.puerto.dao.DaoVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ConsultaVehiculo {

    private final DaoVehiculo daoVehiculo;

    public ConsultaVehiculo(DaoVehiculo daoVehiculo) {
        this.daoVehiculo = daoVehiculo;
    }

    public RespuestaVehiculo ejecutar(String placa){
       return this.daoVehiculo.obtenerVehiculoPorPlaca(placa);
    }
}
