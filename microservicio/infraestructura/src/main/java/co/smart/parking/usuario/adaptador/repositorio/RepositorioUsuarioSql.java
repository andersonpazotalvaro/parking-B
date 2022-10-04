package co.smart.parking.usuario.adaptador.repositorio;

import co.smart.parking.usuario.adaptador.MapperUsuario;
import co.smart.parking.usuario.adaptador.RepositorioUsuarioJpa;
import co.smart.parking.usuario.modelo.dominio.Usuario;
import co.smart.parking.usuario.puerto.repositorio.RepositorioUsuario;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioUsuarioSql implements RepositorioUsuario {

    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final MapperUsuario mapperUsuario;

    public RepositorioUsuarioSql(RepositorioUsuarioJpa repositorioUsuarioJpa, MapperUsuario mapperUsuario) {
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.mapperUsuario = mapperUsuario;
    }


    @Override
    public boolean existePorNombreUsuario(String nombreUsuario) {
        return this.repositorioUsuarioJpa.existsByNombreUsuario(nombreUsuario);
    }

    @Override
    public boolean guardarUsuario(Usuario usuario) {
        var entidad = this.mapperUsuario.crearEntidad(usuario);
        this.repositorioUsuarioJpa.save(entidad);
        return true;
    }
}
