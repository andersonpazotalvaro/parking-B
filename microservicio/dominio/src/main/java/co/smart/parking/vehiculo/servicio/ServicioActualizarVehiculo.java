package co.smart.parking.vehiculo.servicio;

import co.smart.parking.excepcion.ExcepcionInexistente;
import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import co.smart.parking.vehiculo.puerto.repositorio.RepositorioVehiculo;
import org.springframework.stereotype.Service;

@Service
public class ServicioActualizarVehiculo {

    private static final String NO_SE_PUEDE_ACTUALIZAR = "No se puede actualizar ya que el vehiculo no existe";
    private final RepositorioVehiculo repositorioVehiculo;

    public ServicioActualizarVehiculo(RepositorioVehiculo repositorioVehiculo) {
        this.repositorioVehiculo = repositorioVehiculo;
    }

    public boolean ejecutar(Vehiculo vehiculo){
        validarExistencia(vehiculo.getPlaca());
        return this.repositorioVehiculo.actualizar(vehiculo);
    }

    private void validarExistencia(String placa){
        if (!this.repositorioVehiculo.existePorPlaca(placa)) {
            throw new ExcepcionInexistente(NO_SE_PUEDE_ACTUALIZAR);
        }
    }
}
