package co.smart.parking.vehiculo.adaptador;


import co.smart.parking.vehiculo.entidad.EntidadVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioVehiculoJpa extends JpaRepository<EntidadVehiculo, Long> {

    void deleteByPlaca(String placa);
    EntidadVehiculo findByPlaca(String placa);
    List<EntidadVehiculo> findByActivoTrue();
    List<EntidadVehiculo> findAllById(Long id);
}
