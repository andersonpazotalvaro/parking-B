package co.smart.parking.usuario.comando.manejador;

import co.smart.parking.usuario.comando.RequestUsuarioTransaccion;
import co.smart.parking.usuario.comando.fabrica.FabricaUsuario;
import co.smart.parking.usuario.servicio.ServicioGuardarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorGuardarUsuario {

    private final ServicioGuardarUsuario servicioGuardarUsuario;
    private final FabricaUsuario fabricaUsuario;


    public ManejadorGuardarUsuario(ServicioGuardarUsuario servicioGuardarUsuario, FabricaUsuario fabricaUsuario) {
        this.servicioGuardarUsuario = servicioGuardarUsuario;
        this.fabricaUsuario = fabricaUsuario;
    }

    public boolean ejecutar(RequestUsuarioTransaccion requestUsuarioTransaccion) {
        var usuario = this.fabricaUsuario.crear(requestUsuarioTransaccion);
        return this.servicioGuardarUsuario.ejecutar(usuario);
    }
}
