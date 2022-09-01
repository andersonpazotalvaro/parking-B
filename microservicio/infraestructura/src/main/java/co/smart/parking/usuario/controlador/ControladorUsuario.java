package co.smart.parking.usuario.controlador;

import co.smart.parking.usuario.comando.RequestUsuarioTransaccion;
import org.springframework.web.bind.annotation.GetMapping;

public class ControladorUsuario {

    @GetMapping("/dummy")
    public RequestUsuarioTransaccion dummy(){
        return RequestUsuarioTransaccion.crearDummy();
    }
}
