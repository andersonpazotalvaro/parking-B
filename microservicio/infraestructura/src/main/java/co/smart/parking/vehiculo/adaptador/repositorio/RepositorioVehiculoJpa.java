package co.smart.parking.vehiculo.adaptador.repositorio;


import co.smart.parking.vehiculo.entidad.EntidadVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioVehiculoJpa extends JpaRepository<EntidadVehiculo, Long> {

    EntidadVehiculo findByPlaca(String placa);

    Optional<List<EntidadVehiculo>> findByActivoTrue();

}
