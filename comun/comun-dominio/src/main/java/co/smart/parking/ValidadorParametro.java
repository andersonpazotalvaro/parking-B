package co.smart.parking;

import co.smart.parking.excepcion.ExcepcionArgumentoInvalido;
import org.springframework.util.StringUtils;

public class ValidadorParametro {

    public static void validarValorNulo(Object valor, String mensaje) {
        if(valor == null) {
            throw new ExcepcionArgumentoInvalido(mensaje);
        }
    }


    public static void validarValorVacio(String valor, String mensaje) {
        if(!StringUtils.hasText(valor)) {
            throw new ExcepcionArgumentoInvalido(mensaje);
        }
    }
}
