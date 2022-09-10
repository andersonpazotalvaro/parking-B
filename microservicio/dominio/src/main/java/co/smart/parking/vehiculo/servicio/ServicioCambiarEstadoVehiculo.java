package co.smart.parking.vehiculo.servicio;

import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoCambiarEstado;
import co.smart.parking.vehiculo.puerto.RepositorioVehiculo;
import org.springframework.stereotype.Service;

@Service
public class ServicioCambiarEstadoVehiculo {

    private static final String mensajeCambiarEstado="no se pudo cambiar estado";

    private final RepositorioVehiculo repositorioVehiculo;

    public ServicioCambiarEstadoVehiculo(RepositorioVehiculo repositorioVehiculo) {
        this.repositorioVehiculo = repositorioVehiculo;
    }


    public ResponseVehiculoCambiarEstado ejecutar(String placa){
        return this.repositorioVehiculo.cambiarEstado(placa);
    }
}
