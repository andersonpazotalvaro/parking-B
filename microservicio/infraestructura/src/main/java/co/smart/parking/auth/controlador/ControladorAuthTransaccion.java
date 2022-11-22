package co.smart.parking.auth.controlador;

import co.smart.parking.auth.adaptador.Auth;
import co.smart.parking.jwToken.modelo.dto.RespuestaJwToken;
import co.smart.parking.rabbitmq.adaptador.EscritorMensaje;
import co.smart.parking.usuario.comando.RequestUsuarioTransaccion;
import co.smart.parking.usuario.comando.fabrica.FabricaUsuario;
import co.smart.parking.usuario.comando.manejador.ManejadorGuardarUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class ControladorAuthTransaccion {

    private final Auth auth;
    private final FabricaUsuario fabricaUsuario;
    private final ManejadorGuardarUsuario manejadorGuardarUsuario;

    private final EscritorMensaje escritorMensaje;

    @Autowired
    public ControladorAuthTransaccion(Auth auth, FabricaUsuario fabricaUsuario, ManejadorGuardarUsuario manejadorGuardarUsuario, EscritorMensaje escritorMensaje) {
        this.auth = auth;
        this.fabricaUsuario = fabricaUsuario;
        this.manejadorGuardarUsuario = manejadorGuardarUsuario;
        this.escritorMensaje = escritorMensaje;
    }

    @PostMapping
    public RespuestaJwToken ingresarUsuario(@RequestBody RequestUsuarioTransaccion requestUsuarioTransaccion){
        var usuario = this.fabricaUsuario.crear(requestUsuarioTransaccion);
        return this.auth.login(usuario);
    }

    @PutMapping
    public boolean registrarUsuario(@RequestBody RequestUsuarioTransaccion requestUsuarioTransaccion) {
        return this.manejadorGuardarUsuario.ejecutar(requestUsuarioTransaccion);
    }


}
