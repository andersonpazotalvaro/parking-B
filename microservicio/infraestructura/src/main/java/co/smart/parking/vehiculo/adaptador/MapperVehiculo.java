package co.smart.parking.vehiculo.adaptador;

import co.smart.parking.usuario.adaptador.MapperUsuarioPerfil;
import co.smart.parking.usuario.modelo.dominio.UsuarioPerfil;
import co.smart.parking.vehiculo.entidad.EntidadVehiculo;
import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.RespuestaVehiculo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class MapperVehiculo {

    private final MapperUsuarioPerfil mapperUsuarioPerfil;

    public MapperVehiculo(MapperUsuarioPerfil mapperUsuarioPerfil) {
        this.mapperUsuarioPerfil = mapperUsuarioPerfil;
    }


    public List<RespuestaVehiculo> crearRespuestas(List<EntidadVehiculo> entidadVehiculos) {
        var respuestaVehiculos = new ArrayList<RespuestaVehiculo>();

        entidadVehiculos.forEach(entidadVehiculo -> {
            respuestaVehiculos.add(this.crearRespuesta(entidadVehiculo));
        });

        return respuestaVehiculos;
    }

    public RespuestaVehiculo crearRespuesta(EntidadVehiculo entidadVehiculo){

        return new RespuestaVehiculo(
                this.mapperUsuarioPerfil.crearRespuesta(entidadVehiculo.getEntidadUsuarioPerfil()),
                entidadVehiculo.getPlaca(),
                false
        );
    }

    public EntidadVehiculo crearEntidad(Vehiculo vehiculo){
        return new EntidadVehiculo(
                vehiculo.getPlaca(),
                this.mapperUsuarioPerfil.crearEntidad(vehiculo.getUsuarioPerfil())
        );
    }

    public List<EntidadVehiculo> crearEntidades(List<Vehiculo> vehiculos) {
        var entidades = new ArrayList<EntidadVehiculo>();

        vehiculos.forEach(vehiculo -> {
            entidades.add(crearEntidad(vehiculo));
        });

        return entidades;
    }

}
