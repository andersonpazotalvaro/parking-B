package co.smart.parking;

import co.smart.parking.excepcion.ExcepcionArgumentoInvalido;
import org.springframework.util.StringUtils;

public class ValidadorParametro {


    public static void validarValorNoVacio(String valor, String mensaje) {
        if(valor.isEmpty()) {
            throw new ExcepcionArgumentoInvalido(mensaje);
        }
    }
}
