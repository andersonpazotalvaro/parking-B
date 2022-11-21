package co.smart.parking.usuario.servicio;

import co.smart.parking.usuario.modelo.dtoRespuesta.RespuestaUsuarioPerfil;
import co.smart.parking.usuario.puerto.repositorio.RepositorioUsuario;
import co.smart.parking.vehiculo.puerto.dao.DaoVehiculo;
import org.springframework.stereotype.Service;

@Service
public class ServicioConsultarUsuarioPerfil {

    private final ServicioConsultarUsuario servicioConsultarUsuario;
    private final DaoVehiculo daoVehiculo;

    public ServicioConsultarUsuarioPerfil(RepositorioUsuario repositorioUsuario, ServicioConsultarUsuario servicioConsultarUsuario, DaoVehiculo daoVehiculo) {
        this.servicioConsultarUsuario = servicioConsultarUsuario;
        this.daoVehiculo = daoVehiculo;
    }

    public RespuestaUsuarioPerfil ejecutar(String nombreUsuario) {
        var usuario = this.servicioConsultarUsuario.ejecutar(nombreUsuario);
        var vehiculos = daoVehiculo.obtenerPorUsuario(nombreUsuario);
        return new RespuestaUsuarioPerfil(
                usuario.getNombreUsuario(),
                usuario.getRoles(),
                vehiculos
        );
    }
}
