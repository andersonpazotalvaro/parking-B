package co.smart.parking.usuario.servicio;


import co.smart.parking.excepcion.ExcepcionDuplicidad;
import co.smart.parking.usuario.modelo.dominio.Usuario;
import co.smart.parking.usuario.puerto.repositorio.RepositorioUsuario;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarUsuarioPerfil {

    private static final String EL_USUARIO_S_YA_EXISTE = "El usuario %s ya existe";

    private final RepositorioUsuario repositorioUsuario;

    public ServicioGuardarUsuarioPerfil(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }


    public boolean ejecutar(Usuario usuario) {
        validarExistencia(usuario);
        return this.repositorioUsuario.guardarUsuario(usuario);
    }

    private void validarExistencia(Usuario usuario) {
        if(this.repositorioUsuario.existePorNombreUsuario(usuario.getNombreUsuario())) {
            throw new ExcepcionDuplicidad(String.format(EL_USUARIO_S_YA_EXISTE, usuario.getNombreUsuario()));
        }
    }

}
