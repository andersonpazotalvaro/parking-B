package co.smart.parking.vehiculo.controlador;

import co.smart.parking.vehiculo.consulta.ConsultaVehiculo;
import co.smart.parking.vehiculo.consulta.ConsultaVehiculoTodos;
import co.smart.parking.vehiculo.consulta.ConsultaVehiculosActivos;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoConsultar;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoConsultarTodos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vehiculo")
public class ControladorVehiculoConsulta {

    private final ConsultaVehiculo consultaVehiculo;

    private final ConsultaVehiculosActivos consultaVehiculosActivos;

    private final ConsultaVehiculoTodos consultaVehiculoTodos;


    public ControladorVehiculoConsulta(ConsultaVehiculo consultaVehiculo, ConsultaVehiculosActivos consultaVehiculosActivos, ConsultaVehiculoTodos consultaVehiculoTodos) {
        this.consultaVehiculo = consultaVehiculo;
        this.consultaVehiculosActivos = consultaVehiculosActivos;
        this.consultaVehiculoTodos = consultaVehiculoTodos;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseVehiculoConsultar> consultar(@PathVariable Long id){

        try {
            ResponseVehiculoConsultar responseVehiculoConsultar=  this.consultaVehiculo.ejecutar(id);
            return new ResponseEntity<>(responseVehiculoConsultar, HttpStatus.OK);
        } catch (Exception exception) {
            return null;
        }
    }

    @GetMapping
    public ResponseEntity<ResponseVehiculoConsultarTodos> consultartodos(){

        try {
            ResponseVehiculoConsultarTodos responseVehiculoConsultar= this.consultaVehiculoTodos.ejecutar();
            return new ResponseEntity<>(responseVehiculoConsultar, HttpStatus.OK);
        } catch (Exception exception) {
            return null;
        }
    }

    @GetMapping(value = "/activos")
    public ResponseEntity<ResponseVehiculoConsultarTodos> consultar(){

        try {
            ResponseVehiculoConsultarTodos responseVehiculoConsultar= this.consultaVehiculosActivos.ejecutar();
            return new ResponseEntity<>(responseVehiculoConsultar, HttpStatus.OK);
        } catch (Exception exception) {
            return null;
        }
    }


}
