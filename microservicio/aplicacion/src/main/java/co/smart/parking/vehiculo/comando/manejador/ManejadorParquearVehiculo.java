package co.smart.parking.vehiculo.comando.manejador;

import co.smart.parking.usuario.comando.fabrica.FabricaUsuario;
import co.smart.parking.usuario.puerto.dao.DaoUsuario;
import co.smart.parking.usuario.servicio.ServicioConsultarUsuarioPerfil;
import co.smart.parking.vehiculo.comando.RequestVehiculoTransaccion;
import co.smart.parking.vehiculo.comando.fabrica.FabricaVehiculo;
import co.smart.parking.vehiculo.servicio.ServicioParquearVehiculo;
import org.springframework.stereotype.Component;

@Component
public class ManejadorParquearVehiculo {

    private final ServicioParquearVehiculo servicioParquearVehiculo;
    private final DaoUsuario daoUsuario;
    private final ServicioConsultarUsuarioPerfil servicioConsultarUsuarioPerfil;
    private final FabricaVehiculo fabricaVehiculo;
    private final FabricaUsuario fabricaUsuario;

    public ManejadorParquearVehiculo(ServicioParquearVehiculo servicioParquearVehiculo, DaoUsuario daoUsuario, ServicioConsultarUsuarioPerfil servicioConsultarUsuarioPerfil, FabricaVehiculo fabricaVehiculo, FabricaUsuario fabricaUsuario) {
        this.servicioParquearVehiculo = servicioParquearVehiculo;
        this.daoUsuario = daoUsuario;
        this.servicioConsultarUsuarioPerfil = servicioConsultarUsuarioPerfil;
        this.fabricaVehiculo = fabricaVehiculo;
        this.fabricaUsuario = fabricaUsuario;
    }

    public boolean ejecutar(RequestVehiculoTransaccion requestVehiculoTransaccion) {
        var usuario = this.daoUsuario.obtenerUsuarioPorNombreDeUsuario(requestVehiculoTransaccion.getNombreUsuario());
        var usuarioPerfil = this.servicioConsultarUsuarioPerfil.ejecutar(usuario.getNombreUsuario());
        var vehiculo = this.fabricaVehiculo.crear(requestVehiculoTransaccion, usuarioPerfil, usuario);
        return this.servicioParquearVehiculo.ejecutar(vehiculo);
    }
}
