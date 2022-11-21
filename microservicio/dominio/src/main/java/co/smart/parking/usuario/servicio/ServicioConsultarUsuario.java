package co.smart.parking.usuario.servicio;

import co.smart.parking.excepcion.ExcepcionInexistente;
import co.smart.parking.usuario.modelo.dtoRespuesta.RespuestaUsuario;
import co.smart.parking.usuario.puerto.dao.DaoUsuario;
import co.smart.parking.usuario.puerto.repositorio.RepositorioUsuario;
import org.springframework.stereotype.Service;

@Service
public class ServicioConsultarUsuario {

    private static final String EL_USUARIO_S_NO_EXISTE = "El usuario %s no existe";

    private final RepositorioUsuario repositorioUsuario;
    private final DaoUsuario daoUsuario;

    public ServicioConsultarUsuario(RepositorioUsuario repositorioUsuario, DaoUsuario daoUsuario) {
        this.repositorioUsuario = repositorioUsuario;
        this.daoUsuario = daoUsuario;
    }


    public RespuestaUsuario ejecutar(String nombreUsuario) {
        validarExistencia(nombreUsuario);
        return this.daoUsuario.obtenerUsuarioPorNombreDeUsuario(nombreUsuario);
    }

    private void validarExistencia(String nombreUsuario) {
        if(!this.repositorioUsuario.existePorNombreUsuario(nombreUsuario)) {
            throw new ExcepcionInexistente(String.format(EL_USUARIO_S_NO_EXISTE, nombreUsuario));
        }
    }

}
