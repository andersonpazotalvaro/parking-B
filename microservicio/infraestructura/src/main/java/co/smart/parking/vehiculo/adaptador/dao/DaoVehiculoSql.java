package co.smart.parking.vehiculo.adaptador.dao;

import co.smart.parking.vehiculo.adaptador.RepositorioVehiculoJpa;
import co.smart.parking.vehiculo.adaptador.MapperVehiculo;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.RespuestaVehiculo;
import co.smart.parking.vehiculo.puerto.dao.DaoVehiculo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoVehiculoSql implements DaoVehiculo {

    private final RepositorioVehiculoJpa repositorioVehiculoJpa;
    private final MapperVehiculo mapperVehiculo;

    public DaoVehiculoSql(RepositorioVehiculoJpa repositorioVehiculoJpa, MapperVehiculo mapperVehiculo) {
        this.repositorioVehiculoJpa = repositorioVehiculoJpa;
        this.mapperVehiculo = mapperVehiculo;
    }

    @Override
    public RespuestaVehiculo obtenerVehiculoPorPlaca(String placa) {
        var entidadVehiculo = this.repositorioVehiculoJpa.findByPlaca(placa);
        return this.mapperVehiculo.crearResponse(entidadVehiculo);
    }

    @Override
    public List<RespuestaVehiculo> obtenerVehiculos() {
        var entidadVehiculos = this.repositorioVehiculoJpa.findAll();
        return this.mapperVehiculo.crearResponses(entidadVehiculos);
    }

    @Override
    public List<RespuestaVehiculo> obtenerVehiculosActivos() {
        var entidadVehiculos = this.repositorioVehiculoJpa.findByActivoTrue();
        return this.mapperVehiculo.crearResponses(entidadVehiculos);
    }
}

