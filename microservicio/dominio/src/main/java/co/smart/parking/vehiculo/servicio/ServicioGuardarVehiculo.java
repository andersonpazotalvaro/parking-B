package co.smart.parking.vehiculo.servicio;

import co.smart.parking.excepcion.ExcepcionDuplicidad;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.RespuestaVehiculo;
import co.smart.parking.vehiculo.puerto.dao.DaoVehiculo;
import co.smart.parking.vehiculo.puerto.repositorio.RepositorioVehiculo;
import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarVehiculo {

    private static final String NO_SE_PUDO_GUARDAR = "No se pudo Guardar";

    private final RepositorioVehiculo repositorioVehiculo;
    private final DaoVehiculo daoVehiculo;


    public ServicioGuardarVehiculo(RepositorioVehiculo repositorioVehiculo, DaoVehiculo daoVehiculo) {
        this.repositorioVehiculo = repositorioVehiculo;
        this.daoVehiculo = daoVehiculo;
    }


    public RespuestaVehiculo ejecutar(Vehiculo vehiculo){

        validarExistencia(vehiculo);
        this.repositorioVehiculo.guardar(vehiculo);
        return this.daoVehiculo.obtenerVehiculoPorPlaca(vehiculo.getPlaca());
    }


    private void validarExistencia(Vehiculo vehiculo){
        if (this.repositorioVehiculo.existePorPlaca(vehiculo.getPlaca())) {
            throw new ExcepcionDuplicidad(NO_SE_PUDO_GUARDAR);
        }
    }
}
