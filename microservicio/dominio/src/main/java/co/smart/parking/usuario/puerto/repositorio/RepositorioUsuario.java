package co.smart.parking.usuario.puerto.repositorio;

import co.smart.parking.usuario.modelo.dominio.Usuario;

public interface RepositorioUsuario {

    boolean existePorNombreUsuario(String nombreUsuario);
    boolean guardarUsuario(Usuario usuario);
}
