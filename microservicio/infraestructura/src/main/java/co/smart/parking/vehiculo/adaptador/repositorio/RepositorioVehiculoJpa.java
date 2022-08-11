package co.smart.parking.vehiculo.adaptador.repositorio;


import co.smart.parking.vehiculo.adaptador.entidad.EntidadVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioVehiculoJpa extends JpaRepository<EntidadVehiculo, Long> {

    EntidadVehiculo findBy();

    EntidadVehiculo findByActivoTrue();

}
