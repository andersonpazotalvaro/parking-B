package co.smart.parking.vehiculo.comando.manejador;

import co.smart.parking.usuario.comando.fabrica.FabricaUsuario;
import co.smart.parking.usuario.puerto.dao.DaoUsuario;
import co.smart.parking.vehiculo.comando.RequestVehiculoTransaccion;
import co.smart.parking.vehiculo.comando.fabrica.FabricaVehiculo;
import co.smart.parking.vehiculo.servicio.ServicioParquearVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorParquearVehiculo {

    private final ServicioParquearVehiculo servicioParquearVehiculo;
    private final FabricaVehiculo fabricaVehiculo;

    public ManejadorParquearVehiculo(ServicioParquearVehiculo servicioParquearVehiculo, FabricaVehiculo fabricaVehiculo) {
        this.servicioParquearVehiculo = servicioParquearVehiculo;
        this.fabricaVehiculo = fabricaVehiculo;
    }

    public boolean ejecutar(RequestVehiculoTransaccion requestVehiculoTransaccion) {
        var vehiculo = this.fabricaVehiculo.crear(requestVehiculoTransaccion);
        return this.servicioParquearVehiculo.ejecutar(vehiculo);
    }
}
