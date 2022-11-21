package co.smart.parking.vehiculo.puerto.dao;

import co.smart.parking.vehiculo.modelo.dtoRespuesta.RespuestaVehiculoMovimiento;


public interface DaoVehiculoMovimiento {

    RespuestaVehiculoMovimiento obtenerUltimoMovimientoPorVehiculo(String vehiculoPlaca);
}
