package co.smart.parking.usuario.consulta;

import co.smart.parking.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import co.smart.parking.usuario.puerto.DaoUsuario;
import org.springframework.stereotype.Component;

@Component
public class ConsultarUsuario {

    private final DaoUsuario daoUsuario;

    public ConsultarUsuario(DaoUsuario daoUsuario) {
        this.daoUsuario = daoUsuario;
    }

    public RespuestaUsuario ejecutar(String nombreUsuario) {
        return this.daoUsuario.obtenerUsuarioPorNombreDeUsuario(nombreUsuario);
    }
}
