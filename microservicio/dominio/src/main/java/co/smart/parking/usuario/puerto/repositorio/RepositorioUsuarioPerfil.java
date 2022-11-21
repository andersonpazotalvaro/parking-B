package co.smart.parking.usuario.puerto.repositorio;

import co.smart.parking.usuario.modelo.dominio.UsuarioPerfil;

public interface RepositorioUsuarioPerfil {

    boolean existePorNombreUsuario(String nombreUsuario);
    boolean guardarUsuarioPerfil(UsuarioPerfil usuarioPerfil);
}
