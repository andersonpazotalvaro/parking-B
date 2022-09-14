package co.smart.parking.vehiculo.adaptador.mapper;

import co.smart.parking.vehiculo.entidad.EntidadVehiculo;
import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.RespuestaVehiculo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperVehiculo {

    public List<RespuestaVehiculo> crearResponses(List<EntidadVehiculo> entidadVehiculos) {
        var respuestaVehiculos = new ArrayList<RespuestaVehiculo>();

        entidadVehiculos.forEach(entidadVehiculo -> {
            respuestaVehiculos.add(this.crearResponse(entidadVehiculo));
        });

        return respuestaVehiculos;
    }

    public RespuestaVehiculo crearResponse(EntidadVehiculo entidadVehiculo){

        return new RespuestaVehiculo(
                entidadVehiculo.getId(),
                entidadVehiculo.getPlaca(),
                entidadVehiculo.isActivo()
        );
    }

    public EntidadVehiculo crearEntity(Long id, Vehiculo entidadVehiculo){

        return new EntidadVehiculo(
                id,
                entidadVehiculo.getPlaca(),
                entidadVehiculo.isActivo()
        );

    }

    public EntidadVehiculo crearEntity(Vehiculo entidadVehiculo){

        return new EntidadVehiculo(
                entidadVehiculo.getPlaca(),
                entidadVehiculo.isActivo()
        );

    }

}
