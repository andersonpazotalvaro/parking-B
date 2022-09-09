package co.smart.parking.vehiculo.servicio;

import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoConsultarTodos;
import co.smart.parking.vehiculo.puerto.RepositorioVehiculo;

public class ServicioConsultarTodosVehiculo {

    private static final String mensajeConsultarTodos="no se encontraron vehiculos";

    private final RepositorioVehiculo repositorioVehiculo;

    public ServicioConsultarTodosVehiculo(RepositorioVehiculo repositorioVehiculo) {
        this.repositorioVehiculo = repositorioVehiculo;
    }

    public ResponseVehiculoConsultarTodos ejecutar(){

            return new ResponseVehiculoConsultarTodos(this.repositorioVehiculo.listar());
    }
}
