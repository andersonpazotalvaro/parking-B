package co.smart.parking.vehiculo.controlador;

import co.smart.parking.vehiculo.consulta.ConsultaVehiculo;
import co.smart.parking.vehiculo.consulta.ConsultaVehiculoTodos;
import co.smart.parking.vehiculo.consulta.ConsultaVehiculosActivos;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.RespuestaVehiculo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


    @GetMapping(value = "/{placa}")
    public RespuestaVehiculo consultar(@PathVariable String placa){
        return this.consultaVehiculo.ejecutar(placa);
    }

    @GetMapping
    public List<RespuestaVehiculo> consultarTodos(){
        return this.consultaVehiculoTodos.ejecutar();
    }

    @GetMapping(value = "/activos")
    public List<RespuestaVehiculo> consultarActivos(){
        return this.consultaVehiculoTodos.ejecutar();
    }

}
