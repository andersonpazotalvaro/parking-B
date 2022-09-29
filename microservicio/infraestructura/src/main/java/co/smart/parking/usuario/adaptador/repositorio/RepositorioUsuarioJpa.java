package co.smart.parking.usuario.adaptador.repositorio;

import co.smart.parking.usuario.adaptador.entidad.EntidadUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuarioJpa extends JpaRepository<EntidadUsuario, Long> {

    EntidadUsuario findByNombreUsuario(String nombreUsuario);
    boolean existsByNombreUsuario(String nombreUsuario);

}
