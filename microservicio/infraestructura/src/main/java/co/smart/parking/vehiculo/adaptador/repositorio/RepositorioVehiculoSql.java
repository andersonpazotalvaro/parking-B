package co.smart.parking.vehiculo.adaptador.repositorio;

import co.smart.parking.vehiculo.adaptador.RepositorioVehiculoJpa;
import co.smart.parking.vehiculo.adaptador.MapperVehiculo;
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
    public String guardar(Vehiculo vehiculo) {
        var entidadVehiculo = this.mapperVehiculo.crearEntidad(vehiculo);
        return this.repositorioVehiculoJpa.save(entidadVehiculo).getPlaca();
    }

    @Override
    public boolean actualizar(Vehiculo vehiculo) {
        var entidadVehiculo = this.mapperVehiculo.crearEntidad(vehiculo);
        this.repositorioVehiculoJpa.save(entidadVehiculo);
        return true;
    }

    @Override
    public boolean existePorPlaca(String placa) {
        return this.repositorioVehiculoJpa.findByPlaca(placa) != null;
    }

    @Override
    public boolean eliminarPorPlaca(String id) {
        this.repositorioVehiculoJpa.deleteById(id);
        return true;
    }

}
