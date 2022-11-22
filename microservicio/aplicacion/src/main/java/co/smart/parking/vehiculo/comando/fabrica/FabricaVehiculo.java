package co.smart.parking.vehiculo.comando.fabrica;

import co.smart.parking.vehiculo.comando.RequestVehiculoTransaccion;
import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import org.springframework.stereotype.Component;


@Component
public class FabricaVehiculo {

    public Vehiculo crear(RequestVehiculoTransaccion requestVehiculoTransaccion){
        return new Vehiculo(
                requestVehiculoTransaccion.getPlaca()
        );
    }
}
