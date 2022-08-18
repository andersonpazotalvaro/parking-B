package co.smart.parking.usuario.comando;

import co.smart.parking.parqueadero.comando.RequestParqueaderoTransaccion;
import co.smart.parking.usuario.modelo.dominio.Usuario;
import co.smart.parking.vehiculo.comando.RequestVehiculoTransaccion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestUsuarioTransaccion {

    private String identificacion;

    private String nombre;

    private String correo;

    private RequestVehiculoTransaccion vehiculoTransaccion;

    private RequestParqueaderoTransaccion parqueaderoTransaccion;


    public static RequestUsuarioTransaccion crearDummy(){return new RequestUsuarioTransaccion();}
}



