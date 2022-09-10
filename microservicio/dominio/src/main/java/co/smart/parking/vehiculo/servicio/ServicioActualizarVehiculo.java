package co.smart.parking.vehiculo.servicio;

import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import co.smart.parking.vehiculo.puerto.RepositorioVehiculo;
import org.springframework.stereotype.Service;

@Service
public class ServicioActualizarVehiculo {

    private static final String mensajeActualizar="no se puede actualizar, no se encontro vehiculo";

    private final RepositorioVehiculo repositorioVehiculo;

    public ServicioActualizarVehiculo(RepositorioVehiculo repositorioVehiculo) {
        this.repositorioVehiculo = repositorioVehiculo;
    }

    public boolean ejecutar(Long id, Vehiculo vehiculo){
        validarExistencia(id);
        return this.repositorioVehiculo.actualizar(id, vehiculo);
    }

    private void validarExistencia(Long id){
        if (!this.repositorioVehiculo.existe(id)) {
            throw new RuntimeException(mensajeActualizar);
        }
    }
}
