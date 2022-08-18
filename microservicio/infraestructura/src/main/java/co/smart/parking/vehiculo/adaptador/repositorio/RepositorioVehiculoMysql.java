package co.smart.parking.vehiculo.adaptador.repositorio;

import co.smart.parking.vehiculo.RepositorioVehiculo;
import co.smart.parking.vehiculo.adaptador.entidad.EntidadVehiculo;
import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoCambiarEstado;

import java.util.List;
import java.util.Optional;

public class RepositorioVehiculoMysql implements RepositorioVehiculo {

    private final RepositorioVehiculoJpa repositorioVehiculoJpa;

    public RepositorioVehiculoMysql(RepositorioVehiculoJpa repositorioVehiculoJpa) {
        this.repositorioVehiculoJpa = repositorioVehiculoJpa;
    }

    @Override
    public List<Vehiculo> listar() {
        List<EntidadVehiculo> entidades = this.repositorioVehiculoJpa.findAll();

       return entidades.stream().map(entidad -> Vehiculo.of(entidad.getPlaca())).toList();
    }

    @Override
    public List<Vehiculo> listarActivos() {
        Optional<List<EntidadVehiculo>> entidades = this.repositorioVehiculoJpa.findByActivoTrue();
        //Revisar XD no se que chucha hice
       return entidades.stream().map(entidad -> Vehiculo.of(String.valueOf(entidad.stream().map(ent -> Vehiculo.of(ent.getPlaca())).toList()))).toList();

    }


    @Override
    public ResponseVehiculoCambiarEstado cambiarEstado(Long id,Vehiculo vehiculo) {

        EntidadVehiculo entidadVehiculo = this.repositorioVehiculoJpa.findByPlaca(vehiculo.getPlaca());
        EntidadVehiculo nuevaEntidad = new EntidadVehiculo();
        nuevaEntidad.setId(id);
        String mensaje;
        if(entidadVehiculo.isActivo()){
            mensaje = "se ha inactivado";
            nuevaEntidad.setActivo(false);
        }else {
            mensaje = "se ha activado";
            nuevaEntidad.setActivo(true);
        }

        return new ResponseVehiculoCambiarEstado(mensaje,vehiculo.getPlaca());
    }
}
