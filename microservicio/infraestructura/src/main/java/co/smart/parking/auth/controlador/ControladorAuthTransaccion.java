package co.smart.parking.auth.controlador;

import co.smart.parking.jwToken.modelo.dto.RespuestaJwToken;
import co.smart.parking.usuario.comando.RequestUsuarioTransaccion;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vehiculo")
public class ControladorAuthTransaccion {



    @PostMapping
    public RespuestaJwToken loginUser(@RequestBody RequestUsuarioTransaccion requestUsuarioTransaccion){
        return null;
    }

}
