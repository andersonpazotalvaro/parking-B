package co.smart.parking.vehiculo.controlador;

import co.smart.parking.vehiculo.comando.RequestVehiculoTransaccion;
import co.smart.parking.vehiculo.comando.manejador.ManejadorEliminarVehiculo;
import co.smart.parking.vehiculo.comando.manejador.ManejadorGuardarVehiculo;
import co.smart.parking.vehiculo.comando.manejador.ManejadorCambiarEstadoVehiculo;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.RespuestaVehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vehiculo")
public class ControladorVehiculoTransaccion {

   private final ManejadorGuardarVehiculo manejadorGuardarVehiculo;

   private final ManejadorCambiarEstadoVehiculo manejadorCambiarEstadoVehiculo;

   private final ManejadorEliminarVehiculo manejadorEliminarVehiculo;



    @Autowired
    public ControladorVehiculoTransaccion(ManejadorGuardarVehiculo manejadorGuardarVehiculo, ManejadorCambiarEstadoVehiculo manejadorParquearVehiculo, ManejadorEliminarVehiculo manejadorEliminarVehiculo) {
        this.manejadorGuardarVehiculo = manejadorGuardarVehiculo;
        this.manejadorCambiarEstadoVehiculo = manejadorParquearVehiculo;
        this.manejadorEliminarVehiculo = manejadorEliminarVehiculo;
    }


    @PutMapping(value = "/{nuevoEstado}")
    public boolean cambiarEstadoVehiculo(@RequestBody RequestVehiculoTransaccion requestVehiculoTransaccion, @PathVariable boolean nuevoEstado){
        return this.manejadorCambiarEstadoVehiculo.ejecutar(requestVehiculoTransaccion, nuevoEstado);
    }

    @PostMapping
    public RespuestaVehiculo guardarVehiculo(@RequestBody RequestVehiculoTransaccion requestVehiculoTransaccion){
        return this.manejadorGuardarVehiculo.ejecutar(requestVehiculoTransaccion);
    }

    @DeleteMapping(value = "/{placa}")
    public boolean eliminarVehiculo(@PathVariable String placa){
        return this.manejadorEliminarVehiculo.ejecutar(placa);
    }

}
