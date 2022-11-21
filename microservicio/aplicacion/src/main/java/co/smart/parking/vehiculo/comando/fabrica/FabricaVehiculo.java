package co.smart.parking.vehiculo.comando.fabrica;

import co.smart.parking.usuario.comando.RequestUsuarioTransaccion;
import co.smart.parking.usuario.comando.fabrica.FabricaUsuario;
import co.smart.parking.usuario.comando.fabrica.FabricaUsuarioPerfil;
import co.smart.parking.usuario.modelo.dominio.Usuario;
import co.smart.parking.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import co.smart.parking.usuario.modelo.dtoRespuesta.RespuestaUsuarioPerfil;
import co.smart.parking.vehiculo.comando.RequestVehiculoTransaccion;
import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.RespuestaVehiculo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class FabricaVehiculo {

    private final FabricaUsuarioPerfil fabricaUsuarioPerfil;

    public FabricaVehiculo(FabricaUsuarioPerfil fabricaUsuarioPerfil) {
        this.fabricaUsuarioPerfil = fabricaUsuarioPerfil;
    }

    public Vehiculo crear(RequestVehiculoTransaccion requestVehiculoTransaccion, RespuestaUsuarioPerfil respuestaUsuarioPerfil, RespuestaUsuario usuario){
        return new Vehiculo(
                requestVehiculoTransaccion.getPlaca(),
                this.fabricaUsuarioPerfil.crear(respuestaUsuarioPerfil, usuario)
        );
    }

    public Vehiculo crear(RespuestaVehiculo respuestaVehiculo, RespuestaUsuarioPerfil respuestaUsuarioPerfil, RespuestaUsuario usuario){
        return new Vehiculo(
                respuestaVehiculo.getPlaca(),
                this.fabricaUsuarioPerfil.crear(respuestaUsuarioPerfil, usuario)
        );
    }

    public List<Vehiculo> crearVehiculos(List<RespuestaVehiculo> respuestaVehiculos, RespuestaUsuarioPerfil respuestaUsuarioPerfil, RespuestaUsuario respuestaUsuario){
        var vehiculos = new ArrayList<Vehiculo>();

        respuestaVehiculos.forEach(vehiculo -> {
            vehiculos.add(crear(vehiculo, respuestaUsuarioPerfil, respuestaUsuario));
        });

        return vehiculos;
    }
}
