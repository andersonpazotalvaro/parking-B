package co.smart.parking.vehiculo;

import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoCambiarEstado;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoConsultar;

import java.util.List;

public interface RepositorioVehiculo {


    List<Vehiculo> listar();

    List<Vehiculo> listarActivos();

    ResponseVehiculoCambiarEstado cambiarEstado(Long id,Vehiculo vehiculo);
}
