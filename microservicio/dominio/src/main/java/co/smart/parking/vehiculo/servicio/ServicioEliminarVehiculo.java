package co.smart.parking.vehiculo.servicio;

import co.smart.parking.excepcion.ExcepcionInexistente;
import co.smart.parking.vehiculo.puerto.repositorio.RepositorioVehiculo;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarVehiculo {

    private static final String NO_SE_PUDO_ELIMINAR_EL_VEHICULO = "No se pudo eliminar";

    private final RepositorioVehiculo repositorioVehiculo;


    public ServicioEliminarVehiculo(RepositorioVehiculo repositorioVehiculo) {
        this.repositorioVehiculo = repositorioVehiculo;
    }


    public boolean ejecutar(String placa){
        validarExistencia(placa);
        return this.repositorioVehiculo.eliminarPorPlaca(placa);
    }


    private void validarExistencia(String placa){
        if (!this.repositorioVehiculo.existePorPlaca(placa)) {
            throw new ExcepcionInexistente(NO_SE_PUDO_ELIMINAR_EL_VEHICULO);
        }
    }

}
