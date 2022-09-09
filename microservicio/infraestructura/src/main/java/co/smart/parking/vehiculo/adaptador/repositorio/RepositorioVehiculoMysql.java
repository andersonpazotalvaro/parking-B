package co.smart.parking.vehiculo.adaptador.repositorio;

import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoConsultar;
import co.smart.parking.vehiculo.puerto.RepositorioVehiculo;
import co.smart.parking.vehiculo.entidad.EntidadVehiculo;
import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoCambiarEstado;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoGuardar;
import org.springframework.stereotype.Repository;

import java.util.List;
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
    public ResponseVehiculoCambiarEstado cambiarEstado(String placa) {
        String mensaje="";
        List<EntidadVehiculo> entidad = this.repositorioVehiculoJpa.findByPlaca(placa);
        List<Vehiculo> list= entidad.stream().map(a -> new Vehiculo(a.getPlaca(),a.isActivo())).collect(Collectors.toList());

        for (int i=0; i<entidad.size();i++){
            EntidadVehiculo nuevaEntidad = new EntidadVehiculo();

            nuevaEntidad.setId(entidad.get(i).getId());

            if(entidad.get(i).isActivo()){
                mensaje = "se ha inactivado";
                nuevaEntidad.setActivo(false);
                this.repositorioVehiculoJpa.save(nuevaEntidad);
            }else {
                mensaje = "se ha activado";
                nuevaEntidad.setActivo(true);
                this.repositorioVehiculoJpa.save(nuevaEntidad);
            }
        }

        return new ResponseVehiculoCambiarEstado(list);
    }

    @Override
    public boolean existe(String placa) {
        return this.repositorioVehiculoJpa.findByPlaca(placa) != null;
    }

    @Override
    public boolean existe(Long id) {
        return this.repositorioVehiculoJpa.findById(id) !=null;
    }

    @Override
    public ResponseVehiculoConsultar consultarPorId(Long id) {
        String placa = this.repositorioVehiculoJpa.findById(id).get().getPlaca();
        boolean estado= this.repositorioVehiculoJpa.findById(id).get().isActivo();
        Vehiculo vehiculo= new Vehiculo(placa,estado);
        return new ResponseVehiculoConsultar(vehiculo);
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
