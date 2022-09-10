package co.smart.parking.vehiculo.servicio;

import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoGuardar;
import co.smart.parking.vehiculo.puerto.RepositorioVehiculo;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarVehiculo {
    private static final String mensajeEliminar="No se pudo eliminar";

    private final RepositorioVehiculo repositorioVehiculo;


    public ServicioEliminarVehiculo(RepositorioVehiculo repositorioVehiculo) {
        this.repositorioVehiculo = repositorioVehiculo;
    }


    public boolean ejecutar(Long id){
        validarExistencia(id);
        return this.repositorioVehiculo.eliminar(id);
    }


    private void validarExistencia(Long id){
        if (!this.repositorioVehiculo.existe(id)) {
            throw new RuntimeException(mensajeEliminar);
        }
    }


}
