package co.smart.parking.usuario.adaptador;

import co.smart.parking.usuario.adaptador.entidad.EntidadUsuarioPerfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuarioPerfilJpa extends JpaRepository<EntidadUsuarioPerfil, Long> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM USUARIO_PERFIL JOIN USUARIO WHERE USUARIO.NOMBRE_USUARIO == :nombreUsuario")
    EntidadUsuarioPerfil findByNombreUsuario(@Param("nombreUsuario") String nombreUsuario);

    @Query(nativeQuery = true,
            value = "SELECT COUNT(1) FROM USUARIO_PERFIL JOIN USUARIO WHERE USUARIO.NOMBRE_USUARIO == :nombreUsuario")
    boolean existsByNombreUsuario(String nombreUsuario);

}
