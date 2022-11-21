package co.smart.parking.vehiculo.servicio;

import co.smart.parking.vehiculo.TipoVehiculoMovimiento;
import co.smart.parking.vehiculo.puerto.dao.DaoVehiculoMovimiento;
import org.springframework.stereotype.Service;

@Service
public class ServicioObtenerEstadoVehiculo {

    private final DaoVehiculoMovimiento daoVehiculoMovimiento;

    public ServicioObtenerEstadoVehiculo(DaoVehiculoMovimiento daoVehiculoMovimiento) {
        this.daoVehiculoMovimiento = daoVehiculoMovimiento;
    }

    public boolean ejecutar(String vehiculoPlaca) {

        var ultimoMovimiento = this.daoVehiculoMovimiento.obtenerUltimoMovimientoPorVehiculo(vehiculoPlaca);

        if(ultimoMovimiento == null) {
            return false;
        }

        return ultimoMovimiento.getTipoMovimiento().equals(TipoVehiculoMovimiento.ENTRADA.name());
    }

}
