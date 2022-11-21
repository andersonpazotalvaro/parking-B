package co.smart.parking.vehiculo.puerto.repositorio;

import co.smart.parking.vehiculo.modelo.dominio.VehiculoMovimiento;

public interface RepositorioVehiculoMqp {

    void procesarMovimiento(VehiculoMovimiento vehiculoMovimiento);
}
