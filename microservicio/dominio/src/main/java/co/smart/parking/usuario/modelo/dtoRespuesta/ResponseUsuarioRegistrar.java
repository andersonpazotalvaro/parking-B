package co.smart.parking.usuario.modelo.dtoRespuesta;

import lombok.Getter;

@Getter
public class ResponseUsuarioRegistrar {

    private String mensaje;

    private long id;

    public ResponseUsuarioRegistrar(String mensaje, long id) {
        this.mensaje = mensaje;
        this.id = id;
    }
}
