package co.smart.parking.vehiculo.controlador;

import co.smart.parking.vehiculo.comando.RequestVehiculoTransaccion;
import co.smart.parking.vehiculo.comando.manejador.ManejadorEliminarVehiculo;
import co.smart.parking.vehiculo.comando.manejador.ManejadorEstadoVehiculo;
import co.smart.parking.vehiculo.comando.manejador.ManejadorGuardarVehiculo;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoCambiarEstado;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoConsultarTodos;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoGuardar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vehiculo")
public class ControladorVehiculoTransaccion {

   private final ManejadorGuardarVehiculo manejadorGuardarVehiculo;

   private final ManejadorEstadoVehiculo manejadorEstadoVehiculo;

   private final ManejadorEliminarVehiculo manejadorEliminarVehiculo;



    @Autowired
    public ControladorVehiculoTransaccion(ManejadorGuardarVehiculo manejadorGuardarVehiculo, ManejadorEstadoVehiculo manejadorEstadoVehiculo, ManejadorEliminarVehiculo manejadorEliminarVehiculo) {
        this.manejadorGuardarVehiculo = manejadorGuardarVehiculo;
        this.manejadorEstadoVehiculo = manejadorEstadoVehiculo;
        this.manejadorEliminarVehiculo = manejadorEliminarVehiculo;
    }

    @GetMapping(value = "/vehiculo")
    public ResponseEntity<ResponseVehiculoConsultarTodos> consultar(){

        /*try {
            DtoPrestamoConsultarRespuesta dtoPrestamoConsultarRespuesta=  this.servicioPrestamoConsultar.consultar(id);
            return new ResponseEntity<>(dtoPrestamoConsultarRespuesta, HttpStatus.OK);
        } catch (Exception exception) {
            DtoPrestamoConsultarRespuesta dtoPrestamoConsultarRespuesta = new DtoPrestamoConsultarRespuesta("la id: "+
                    id+" no se encuentra");
            return new ResponseEntity<>(dtoPrestamoConsultarRespuesta, HttpStatus.BAD_REQUEST);
        }*/
        return null;
    }


    @PostMapping
    public ResponseEntity<ResponseVehiculoGuardar> guardarVehiculo(@RequestBody RequestVehiculoTransaccion requestVehiculoTransaccion){

        try {
            ResponseVehiculoGuardar responseVehiculoGuardar= this.manejadorGuardarVehiculo.ejecutar(requestVehiculoTransaccion);
            return new ResponseEntity<>(responseVehiculoGuardar, HttpStatus.OK);
        } catch (Exception exception) {
           // ResponseVehiculoGuardar responseVehiculoGuardar = new ResponseVehiculoGuardar();
            //return new ResponseEntity<>(ResponseVehiculoGuardar, HttpStatus.BAD_REQUEST);
            return null;
        }

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> eliminarVehiculo(@PathVariable Long id){
        try {
            this.manejadorEliminarVehiculo.ejecutar(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }catch (Exception exception){
            return null;
        }
    }


    @PutMapping(value = "/{placa}")
    public ResponseEntity<ResponseVehiculoCambiarEstado> cambiarEstado(@PathVariable String placa){
        try {
            ResponseVehiculoCambiarEstado responseVehiculoCambiarEstado = this.manejadorEstadoVehiculo.ejecutar(placa);
            return new ResponseEntity<>(responseVehiculoCambiarEstado,HttpStatus.OK);
        }catch (Exception exception){
            return null;
        }
    }
}
