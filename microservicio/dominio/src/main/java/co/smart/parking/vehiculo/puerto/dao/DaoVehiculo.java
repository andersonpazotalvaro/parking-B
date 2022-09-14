package co.smart.parking.vehiculo.puerto.dao;

import co.smart.parking.vehiculo.modelo.dtoRespuesta.RespuestaVehiculo;

import java.util.List;

public interface DaoVehiculo {

    RespuestaVehiculo obtenerVehiculoPorPlaca(String placa);
    List<RespuestaVehiculo> obtenerVehiculos();
    List<RespuestaVehiculo> obtenerVehiculosActivos();
}
