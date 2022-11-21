package co.smart.parking.usuario.comando.fabrica;

import co.smart.parking.usuario.modelo.dominio.UsuarioPerfil;
import co.smart.parking.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import co.smart.parking.usuario.modelo.dtoRespuesta.RespuestaUsuarioPerfil;
import co.smart.parking.vehiculo.comando.fabrica.FabricaVehiculo;
import org.springframework.stereotype.Component;

@Component
public class FabricaUsuarioPerfil {

    private final FabricaUsuario fabricaUsuario;
    private final FabricaVehiculo fabricaVehiculo;

    public FabricaUsuarioPerfil(FabricaUsuario fabricaUsuario, FabricaVehiculo fabricaVehiculo) {
        this.fabricaUsuario = fabricaUsuario;
        this.fabricaVehiculo = fabricaVehiculo;
    }

    public UsuarioPerfil crear(RespuestaUsuarioPerfil respuestaUsuarioPerfil,  RespuestaUsuario respuestaUsuario) {
        return new UsuarioPerfil(
                this.fabricaUsuario.crear(respuestaUsuario),
                this.fabricaVehiculo.crearVehiculos(respuestaUsuarioPerfil.getVehiculos(), respuestaUsuarioPerfil, respuestaUsuario)
        );
    }
}
