package co.smart.parking.controlador;

import co.smart.parking.usuario.comando.RequestUsuarioTransaccion;
import co.smart.parking.usuario.modelo.dominio.Usuario;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.ResponseVehiculoConsultar;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class ControladorVehiculo {

    @GetMapping(value = "/vehiculo")
    public ResponseEntity<ResponseVehiculoConsultar> consultar(){

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


}
