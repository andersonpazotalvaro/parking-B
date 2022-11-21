package co.smart.parking.usuario.consulta;

import co.smart.parking.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import co.smart.parking.usuario.servicio.ServicioConsultarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ConsultarUsuario {

    private final ServicioConsultarUsuario servicioConsultarUsuario;

    public ConsultarUsuario(ServicioConsultarUsuario servicioConsultarUsuario) {
        this.servicioConsultarUsuario = servicioConsultarUsuario;
    }

    public RespuestaUsuario ejecutar(String nombreUsuario) {
        return this.servicioConsultarUsuario.ejecutar(nombreUsuario);
    }
}
