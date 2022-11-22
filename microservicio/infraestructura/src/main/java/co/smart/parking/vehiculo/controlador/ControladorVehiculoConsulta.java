package co.smart.parking.vehiculo.controlador;

import co.smart.parking.vehiculo.consulta.ConsultaVehiculo;
import co.smart.parking.vehiculo.consulta.ConsultaVehiculoTodos;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.RespuestaVehiculo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("vehiculo")
public class ControladorVehiculoConsulta {

    private final ConsultaVehiculo consultaVehiculo;
    private final ConsultaVehiculoTodos consultaVehiculoTodos;


    public ControladorVehiculoConsulta(ConsultaVehiculo consultaVehiculo, ConsultaVehiculoTodos consultaVehiculoTodos) {
        this.consultaVehiculo = consultaVehiculo;
        this.consultaVehiculoTodos = consultaVehiculoTodos;
    }


    @GetMapping(value = "/{placa}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('ESTUDIANTE')")
    public RespuestaVehiculo consultar(@PathVariable String placa){
        return this.consultaVehiculo.ejecutar(placa);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('ESTUDIANTE')")
    public List<RespuestaVehiculo> consultarTodos(){
        return this.consultaVehiculoTodos.ejecutar();
    }

}
