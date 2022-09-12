package co.smart.parking.vehiculo.servicio;

import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoConsultar;
import co.smart.parking.vehiculo.puerto.RepositorioVehiculo;
import org.springframework.stereotype.Service;

@Service
public class ServicioConsultarVehiculo {

    private static final String mensajeConsultar="vehiculo no encontrado";

    private final RepositorioVehiculo repositorioVehiculo;


    public ServicioConsultarVehiculo(RepositorioVehiculo repositorioVehiculo) {
        this.repositorioVehiculo = repositorioVehiculo;
    }

    public ResponseVehiculoConsultar ejecutar(Long id){
        //validarExistencia(id);
        return this.repositorioVehiculo.consultarPorId(id);
    }

    private void validarExistencia(Long id){
        if (!this.repositorioVehiculo.existe(id)) {
            throw new RuntimeException(mensajeConsultar);
        }
    }
}
