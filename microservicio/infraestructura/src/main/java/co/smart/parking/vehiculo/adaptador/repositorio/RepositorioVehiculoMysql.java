package co.smart.parking.vehiculo.adaptador.repositorio;

import co.smart.parking.vehiculo.puerto.RepositorioVehiculo;
import co.smart.parking.vehiculo.entidad.EntidadVehiculo;
import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoCambiarEstado;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoGuardar;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RepositorioVehiculoMysql implements RepositorioVehiculo {

    private final RepositorioVehiculoJpa repositorioVehiculoJpa;

    public RepositorioVehiculoMysql(RepositorioVehiculoJpa repositorioVehiculoJpa) {
        this.repositorioVehiculoJpa = repositorioVehiculoJpa;
    }

    @Override
    public List<Vehiculo> listar() {
        List<EntidadVehiculo> entidades = this.repositorioVehiculoJpa.findAll();
        return entidades.stream().map(entidad -> Vehiculo.of(entidad.getPlaca(), entidad.isActivo()
        )).collect(Collectors.toList());
    }

    @Override
    public List<Vehiculo> listarActivos() {
        List<EntidadVehiculo> entidades = this.repositorioVehiculoJpa.findByActivoTrue();
        return entidades.stream().map(entidad -> Vehiculo.of(entidad.getPlaca(), entidad.isActivo()
        )).collect(Collectors.toList());
    }


    @Override
    public ResponseVehiculoCambiarEstado cambiarEstado(Long id) {

        /*List<EntidadVehiculo> entidad = this.repositorioVehiculoJpa.findAllById(id);
        EntidadVehiculo nuevaEntidad = new EntidadVehiculo();
        nuevaEntidad.setId(id);
        nuevaEntidad.setPlaca(entidad.stream().map(entidadVehiculo -> entidadVehiculo.getPlaca()));

        if(entidadVehiculo.isActivo()){
            mensaje = "se ha inactivado";
            nuevaEntidad.setActivo(false);
        }else {
            mensaje = "se ha activado";
            nuevaEntidad.setActivo(true);
        }

        return new ResponseVehiculoCambiarEstado(mensaje,vehiculo.getPlaca());*/
        return null;
    }

    @Override
    public boolean existe(String placa) {
        return this.repositorioVehiculoJpa.findByPlaca(placa) != null;
    }

    @Override
    public ResponseVehiculoGuardar guardar(Vehiculo vehiculo) {
        EntidadVehiculo entidad= new EntidadVehiculo(vehiculo.getPlaca());
        EntidadVehiculo entidadDos = this.repositorioVehiculoJpa.save(entidad);
        return new ResponseVehiculoGuardar("se guardo", vehiculo.getPlaca());
    }

    @Override
    public Boolean eliminar(Long id) {
        repositorioVehiculoJpa.findById(id);
        repositorioVehiculoJpa.deleteById(id);
        return true;
    }

    @Override
    public Boolean actualizar(Long id, Vehiculo vehiculo) {
        repositorioVehiculoJpa.findById(id);
        EntidadVehiculo entidadVehiculo = new EntidadVehiculo();
        entidadVehiculo.setPlaca(vehiculo.getPlaca());
        entidadVehiculo.setActivo(vehiculo.isActivo());
        repositorioVehiculoJpa.save(entidadVehiculo);

        return true;
    }
}
