package co.smart.parking.parqueadero.controlador;

import co.smart.parking.parqueadero.comando.RequestParqueaderoTransaccion;
import co.smart.parking.parqueadero.modelo.dtoRespuesta.ResponseParqueaderoGuardarCapacidad;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("parqueadero")
public class ControladorParqueadero {




    @PostMapping
    public ResponseEntity<ResponseParqueaderoGuardarCapacidad> guardarCapacidad(@RequestBody RequestParqueaderoTransaccion dtoPrestamo){

       /* try {
            //Guardar
            return new ResponseEntity<>(ResponseParqueaderoGuardarCapacidad, HttpStatus.OK);
        } catch (Exception exception) {

            return new ResponseEntity<>(dtoPrestamo, HttpStatus.BAD_REQUEST);
        }
*/
        return null;
        }

}
