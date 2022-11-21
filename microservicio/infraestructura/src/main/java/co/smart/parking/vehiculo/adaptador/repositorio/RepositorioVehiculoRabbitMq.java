package co.smart.parking.vehiculo.adaptador.repositorio;

import co.smart.parking.rabbitmq.adaptador.EscritorMensaje;
import co.smart.parking.vehiculo.adaptador.MapperVehiculo;
import co.smart.parking.vehiculo.modelo.dominio.VehiculoMovimiento;
import co.smart.parking.vehiculo.puerto.repositorio.RepositorioVehiculoMqp;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioVehiculoRabbitMq implements RepositorioVehiculoMqp {

    private final EscritorMensaje escritorMensaje;
    private final MapperVehiculo mapperVehiculo;

    public RepositorioVehiculoRabbitMq(EscritorMensaje escritorMensaje, MapperVehiculo mapperVehiculo) {
        this.escritorMensaje = escritorMensaje;
        this.mapperVehiculo = mapperVehiculo;
    }

    @Override
    public void procesarMovimiento(VehiculoMovimiento vehiculoMovimiento) {
        this.escritorMensaje.escribirMensaje(vehiculoMovimiento);
    }
}
