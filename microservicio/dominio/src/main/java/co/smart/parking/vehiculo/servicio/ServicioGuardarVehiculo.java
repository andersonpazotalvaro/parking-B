package co.smart.parking.vehiculo.servicio;

import co.smart.parking.vehiculo.puerto.RepositorioVehiculo;
import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoGuardar;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarVehiculo {

    private static final String mensajeGuardar="No se pudo Guardar";

    private final RepositorioVehiculo repositorioVehiculo;


    public ServicioGuardarVehiculo(RepositorioVehiculo repositorioVehiculo) {
        this.repositorioVehiculo = repositorioVehiculo;
    }


    public ResponseVehiculoGuardar ejecutar(Vehiculo vehiculo){

        //validarExistencia(vehiculo);
        return this.repositorioVehiculo.guardar(vehiculo);
    }


    private void validarExistencia(Vehiculo vehiculo){
        if (this.repositorioVehiculo.existe(vehiculo.getPlaca())) {
            throw new RuntimeException(mensajeGuardar);
        }
    }
}
