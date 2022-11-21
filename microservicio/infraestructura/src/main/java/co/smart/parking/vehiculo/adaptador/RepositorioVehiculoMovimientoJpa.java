package co.smart.parking.vehiculo.adaptador;


import co.smart.parking.vehiculo.entidad.EntidadVehiculo;
import co.smart.parking.vehiculo.entidad.EntidadVehiculoMovimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioVehiculoMovimientoJpa extends JpaRepository<EntidadVehiculoMovimiento, Long> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM VEHICULO_MOVIMIENTO MOVIMIENTO WHERE MOVIMIENTO.VEHICULO_PLACA == :placa ORDER BY MOVIMIENTO.FECHA LIMIT 1")
    Optional<EntidadVehiculoMovimiento> obtenerUltimoMovimientoPorVehiculo(@Param("placa") String vehiculoPlaca);
}
