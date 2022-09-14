package co.smart.parking.vehiculo.comando.fabrica;

import co.smart.parking.vehiculo.comando.RequestVehiculoTransaccion;
import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import lombok.Getter;
import org.springframework.stereotype.Component;


@Component
public class FabricaVehiculo {


    public Vehiculo crear(RequestVehiculoTransaccion requestVehiculoTransaccion, boolean isActive){

        return new Vehiculo(
                requestVehiculoTransaccion.getPlaca(),
                isActive
        );

    }

}
