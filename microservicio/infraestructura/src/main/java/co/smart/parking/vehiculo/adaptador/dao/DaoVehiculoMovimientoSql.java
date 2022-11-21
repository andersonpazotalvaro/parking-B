package co.smart.parking.vehiculo.adaptador.dao;

import co.smart.parking.vehiculo.adaptador.MapperVehiculo;
import co.smart.parking.vehiculo.adaptador.MapperVehiculoMovimiento;
import co.smart.parking.vehiculo.adaptador.RepositorioVehiculoMovimientoJpa;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.RespuestaVehiculoMovimiento;
import co.smart.parking.vehiculo.puerto.dao.DaoVehiculo;
import co.smart.parking.vehiculo.puerto.dao.DaoVehiculoMovimiento;
import org.springframework.stereotype.Component;

@Component
public class DaoVehiculoMovimientoSql implements DaoVehiculoMovimiento {

    private final RepositorioVehiculoMovimientoJpa repositorioVehiculoMovimientoJpa;
    private final DaoVehiculo daoVehiculo;
    private final MapperVehiculo mapperVehiculo;
    private final MapperVehiculoMovimiento mapperVehiculoMovimiento;

    public DaoVehiculoMovimientoSql(RepositorioVehiculoMovimientoJpa repositorioVehiculoMovimientoJpa, DaoVehiculo daoVehiculo, MapperVehiculo mapperVehiculo, MapperVehiculoMovimiento mapperVehiculoMovimiento) {
        this.repositorioVehiculoMovimientoJpa = repositorioVehiculoMovimientoJpa;
        this.daoVehiculo = daoVehiculo;
        this.mapperVehiculo = mapperVehiculo;
        this.mapperVehiculoMovimiento = mapperVehiculoMovimiento;
    }

    @Override
    public RespuestaVehiculoMovimiento obtenerUltimoMovimientoPorVehiculo(String vehiculoPlaca) {
        var ultimoMovimiento = this.repositorioVehiculoMovimientoJpa.obtenerUltimoMovimientoPorVehiculo(
                vehiculoPlaca
        );
        return ultimoMovimiento.map(this.mapperVehiculoMovimiento::crearRespuesta).orElse(null);
    }
}

