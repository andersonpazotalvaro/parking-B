package co.smart.parking.usuario.comando.fabrica;


import co.smart.parking.usuario.comando.RequestUsuarioTransaccion;
import co.smart.parking.usuario.modelo.dominio.Usuario;
import org.springframework.stereotype.Component;

@Component
public class FabricaUsuario {

    public Usuario crear(RequestUsuarioTransaccion requestUsuarioTransaccion) {
        return new Usuario(
                requestUsuarioTransaccion.getNombreUsuario(),
                requestUsuarioTransaccion.getContrasena(),
                requestUsuarioTransaccion.getRoles());
    }
}
