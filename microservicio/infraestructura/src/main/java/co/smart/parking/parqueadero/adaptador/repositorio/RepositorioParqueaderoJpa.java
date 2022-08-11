package co.smart.parking.parqueadero.adaptador.repositorio;

import co.smart.parking.parqueadero.adaptador.entidad.EntidadParqueadero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioParqueaderoJpa extends JpaRepository<EntidadParqueadero, Long> {

    EntidadParqueadero findById();
}
