package co.smart.parking.vehiculo.servicio;

import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoConsultarTodos;
import co.smart.parking.vehiculo.puerto.RepositorioVehiculo;

public class ServicioConsultarActivosVehiculo {

    private static final String mensajeConsultarTodos="no se encontraron activos";

    private final RepositorioVehiculo repositorioVehiculo;

    public ServicioConsultarActivosVehiculo(RepositorioVehiculo repositorioVehiculo) {
        this.repositorioVehiculo = repositorioVehiculo;
    }

    public ResponseVehiculoConsultarTodos ejecutar(){
        return new ResponseVehiculoConsultarTodos(this.repositorioVehiculo.listarActivos());
    }
}
