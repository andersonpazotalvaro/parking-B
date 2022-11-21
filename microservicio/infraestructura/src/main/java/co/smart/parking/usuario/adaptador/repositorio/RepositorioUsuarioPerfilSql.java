package co.smart.parking.usuario.adaptador.repositorio;

import co.smart.parking.usuario.adaptador.MapperUsuario;
import co.smart.parking.usuario.adaptador.MapperUsuarioPerfil;
import co.smart.parking.usuario.adaptador.RepositorioUsuarioPerfilJpa;
import co.smart.parking.usuario.modelo.dominio.UsuarioPerfil;
import co.smart.parking.usuario.puerto.repositorio.RepositorioUsuarioPerfil;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioUsuarioPerfilSql implements RepositorioUsuarioPerfil {

    private final RepositorioUsuarioPerfilJpa repositorioUsuarioPerfilJpa;
    private final MapperUsuarioPerfil mapperUsuarioPerfil;

    public RepositorioUsuarioPerfilSql(RepositorioUsuarioPerfilJpa repositorioUsuarioPerfilJpa, MapperUsuarioPerfil mapperUsuarioPerfil) {
        this.repositorioUsuarioPerfilJpa = repositorioUsuarioPerfilJpa;
        this.mapperUsuarioPerfil = mapperUsuarioPerfil;
    }

    @Override
    public boolean existePorNombreUsuario(String nombreUsuario) {
        return this.repositorioUsuarioPerfilJpa.existsByNombreUsuario(nombreUsuario);
    }

    @Override
    public boolean guardarUsuarioPerfil(UsuarioPerfil usuarioPerfil) {
        var entidad = this.mapperUsuarioPerfil.crearEntidad(usuarioPerfil);
        this.repositorioUsuarioPerfilJpa.save(entidad);
        return true;
    }
}
