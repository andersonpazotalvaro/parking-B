package co.smart.parking.vehiculo.puerto;

import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoCambiarEstado;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoConsultar;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoConsultarTodos;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoGuardar;

import java.util.List;

public interface RepositorioVehiculo {


    List<Vehiculo> listar();

    List<Vehiculo> listarActivos();

    ResponseVehiculoCambiarEstado cambiarEstado(String placa);

    boolean existe(String placa);

    boolean existe(Long id);

    ResponseVehiculoConsultar consultarPorId(Long id);

    ResponseVehiculoGuardar guardar(Vehiculo vehiculo);

    Boolean eliminar(Long id);

    Boolean actualizar(Long id, Vehiculo vehiculo);
}
