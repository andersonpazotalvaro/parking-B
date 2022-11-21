package co.smart.parking.vehiculo.servicio;

import co.smart.parking.vehiculo.TipoVehiculoMovimiento;
import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import co.smart.parking.vehiculo.modelo.dominio.VehiculoMovimiento;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ServicioGenerarMovimiento {

    public VehiculoMovimiento ejecutar(Vehiculo vehiculo, TipoVehiculoMovimiento tipoMovimiento) {
        return new VehiculoMovimiento(
                vehiculo,
                tipoMovimiento,
                LocalDateTime.now()
        );
    }
}
