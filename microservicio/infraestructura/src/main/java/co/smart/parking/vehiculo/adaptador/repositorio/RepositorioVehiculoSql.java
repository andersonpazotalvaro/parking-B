package co.smart.parking.vehiculo.adaptador.repositorio;

import co.smart.parking.vehiculo.adaptador.RepositorioVehiculoJpa;
import co.smart.parking.vehiculo.adaptador.mapper.MapperVehiculo;
import co.smart.parking.vehiculo.puerto.dao.DaoVehiculo;
import co.smart.parking.vehiculo.puerto.repositorio.RepositorioVehiculo;
import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioVehiculoSql implements RepositorioVehiculo {

    private final RepositorioVehiculoJpa repositorioVehiculoJpa;
    private final DaoVehiculo daoVehiculo;
    private final MapperVehiculo mapperVehiculo;

    public RepositorioVehiculoSql(RepositorioVehiculoJpa repositorioVehiculoJpa, DaoVehiculo daoVehiculo, MapperVehiculo mapperVehiculo) {
        this.repositorioVehiculoJpa = repositorioVehiculoJpa;
        this.daoVehiculo = daoVehiculo;
        this.mapperVehiculo = mapperVehiculo;
    }

    @Override
    public Long guardar(Vehiculo vehiculo) {
        var entidadVehiculo = this.mapperVehiculo.crearEntity(vehiculo);
        return this.repositorioVehiculoJpa.save(entidadVehiculo).getId();
    }

    @Override
    public boolean actualizar(Vehiculo vehiculo) {
        var respuestaVehiculo = this.daoVehiculo.obtenerVehiculoPorPlaca(vehiculo.getPlaca());
        var entidadVehiculo = this.mapperVehiculo.crearEntity(respuestaVehiculo.getId(), vehiculo);
        this.repositorioVehiculoJpa.save(entidadVehiculo);
        return true;
    }

    @Override
    public boolean existePorPlaca(String placa) {
        return this.repositorioVehiculoJpa.findByPlaca(placa) != null;
    }

    @Override
    public boolean eliminarPorPlaca(String placa) {
        this.repositorioVehiculoJpa.deleteByPlaca(placa);
        return true;
    }

}
