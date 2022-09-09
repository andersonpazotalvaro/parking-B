package co.smart.parking.vehiculo.controlador;

import co.smart.parking.vehiculo.comando.RequestVehiculoTransaccion;
import co.smart.parking.vehiculo.comando.manejador.ManejadorGuardarVehiculo;
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
    @Autowired
    public ControladorVehiculoTransaccion(ManejadorGuardarVehiculo manejadorGuardarVehiculo) {
        this.manejadorGuardarVehiculo = manejadorGuardarVehiculo;
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
    public ResponseEntity<ResponseVehiculoGuardar> guardarPrestamo(@RequestBody RequestVehiculoTransaccion requestVehiculoTransaccion){

        try {
            ResponseVehiculoGuardar responseVehiculoGuardar= this.manejadorGuardarVehiculo.ejecutar(requestVehiculoTransaccion);
            return new ResponseEntity<>(responseVehiculoGuardar, HttpStatus.OK);
        } catch (Exception exception) {
           // ResponseVehiculoGuardar responseVehiculoGuardar = new ResponseVehiculoGuardar();
            //return new ResponseEntity<>(ResponseVehiculoGuardar, HttpStatus.BAD_REQUEST);
            return null;
        }

    }

}
