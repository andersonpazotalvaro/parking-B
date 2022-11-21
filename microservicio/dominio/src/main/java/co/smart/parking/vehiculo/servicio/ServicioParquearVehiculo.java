package co.smart.parking.vehiculo.servicio;

import co.smart.parking.excepcion.ExcepcionInexistente;
import co.smart.parking.vehiculo.TipoVehiculoMovimiento;
import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import co.smart.parking.vehiculo.puerto.repositorio.RepositorioVehiculo;
import co.smart.parking.vehiculo.puerto.repositorio.RepositorioVehiculoMqp;
import org.springframework.stereotype.Service;

@Service
public class ServicioParquearVehiculo {

    private static final String NO_SE_PUEDE_REGISTRAR_EL_MOVIMIENTO_PORQUE_EL_VEHICULO_NO_EXISTE = "No se puede registrar el movimiento porque el vehiculo no existe";

    private final RepositorioVehiculo repositorioVehiculo;
    private final RepositorioVehiculoMqp repositorioVehiculoMqp;
    private final ServicioGenerarMovimiento servicioGenerarMovimiento;

    public ServicioParquearVehiculo(RepositorioVehiculo repositorioVehiculo, RepositorioVehiculoMqp repositorioVehiculoMqp, ServicioGenerarMovimiento servicioGenerarMovimiento) {
        this.repositorioVehiculo = repositorioVehiculo;
        this.repositorioVehiculoMqp = repositorioVehiculoMqp;
        this.servicioGenerarMovimiento = servicioGenerarMovimiento;
    }

    public boolean ejecutar(Vehiculo vehiculo){
        validarExistencia(vehiculo);
        var movimiento = servicioGenerarMovimiento.ejecutar(vehiculo, TipoVehiculoMovimiento.ENTRADA);
        this.repositorioVehiculoMqp.procesarMovimiento(movimiento);
        return true;
    }


    private void validarExistencia(Vehiculo vehiculo) {
        if(!this.repositorioVehiculo.existePorPlaca(vehiculo.getPlaca())) {
            throw new ExcepcionInexistente(NO_SE_PUEDE_REGISTRAR_EL_MOVIMIENTO_PORQUE_EL_VEHICULO_NO_EXISTE);
        }
    }
}
