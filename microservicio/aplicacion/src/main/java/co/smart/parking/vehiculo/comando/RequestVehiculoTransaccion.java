package co.smart.parking.vehiculo.comando;


import co.smart.parking.usuario.comando.RequestUsuarioTransaccion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestVehiculoTransaccion {

    private String placa;

}
