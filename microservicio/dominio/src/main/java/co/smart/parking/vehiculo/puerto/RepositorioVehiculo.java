package co.smart.parking.vehiculo.puerto;

import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoCambiarEstado;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoConsultar;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoGuardar;

import java.util.List;

public interface RepositorioVehiculo {


    List<Vehiculo> listar();

    List<Vehiculo> listarActivos();

    ResponseVehiculoCambiarEstado cambiarEstado(Long id,Vehiculo vehiculo);

    boolean existe(String placa);

    ResponseVehiculoGuardar guardar(Vehiculo vehiculo);
}
