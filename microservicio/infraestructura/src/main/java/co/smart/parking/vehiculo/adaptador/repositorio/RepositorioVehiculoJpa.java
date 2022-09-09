package co.smart.parking.vehiculo.adaptador.repositorio;


import co.smart.parking.vehiculo.entidad.EntidadVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioVehiculoJpa extends JpaRepository<EntidadVehiculo, Long> {

    List<EntidadVehiculo> findByPlaca(String placa);

   // EntidadVehiculo findById(Long id);

    List<EntidadVehiculo> findByActivoTrue();

    //Optional<List<EntidadVehiculo>> findById(Long id);

    List<EntidadVehiculo> findAllById(Long id);
}
