package co.smart.parking.vehiculo.comando.manejador;

import co.smart.parking.usuario.puerto.dao.DaoUsuario;
import co.smart.parking.usuario.servicio.ServicioConsultarUsuarioPerfil;
import co.smart.parking.vehiculo.comando.RequestVehiculoTransaccion;
import co.smart.parking.vehiculo.comando.fabrica.FabricaVehiculo;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.RespuestaVehiculo;
import co.smart.parking.vehiculo.servicio.ServicioGuardarVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorGuardarVehiculo {

    private final FabricaVehiculo fabricaVehiculo;
    private final DaoUsuario daoUsuario;
    private final ServicioConsultarUsuarioPerfil servicioConsultarUsuarioPerfil;

    private final ServicioGuardarVehiculo servicioGuardarVehiculo;

    public ManejadorGuardarVehiculo(FabricaVehiculo fabricaVehiculo, DaoUsuario daoUsuario, ServicioConsultarUsuarioPerfil servicioConsultarUsuarioPerfil, ServicioGuardarVehiculo servicioGuardarVehiculo) {
        this.fabricaVehiculo = fabricaVehiculo;
        this.daoUsuario = daoUsuario;
        this.servicioConsultarUsuarioPerfil = servicioConsultarUsuarioPerfil;
        this.servicioGuardarVehiculo = servicioGuardarVehiculo;
    }

    public RespuestaVehiculo ejecutar(RequestVehiculoTransaccion requestVehiculoTransaccion) {
        var usuario = this.daoUsuario.obtenerUsuarioPorNombreDeUsuario(requestVehiculoTransaccion.getNombreUsuario());
        var usuarioPerfil = this.servicioConsultarUsuarioPerfil.ejecutar(usuario.getNombreUsuario());
        var vehiculo = this.fabricaVehiculo.crear(requestVehiculoTransaccion, usuarioPerfil, usuario);
        return this.servicioGuardarVehiculo.ejecutar(vehiculo);
    }

}
