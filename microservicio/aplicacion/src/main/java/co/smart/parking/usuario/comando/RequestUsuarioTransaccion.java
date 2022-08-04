package co.smart.parking.usuario.comando;

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


}



