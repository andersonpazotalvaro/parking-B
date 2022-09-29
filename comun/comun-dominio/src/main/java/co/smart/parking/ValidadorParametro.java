package co.smart.parking;

import co.smart.parking.excepcion.ExcepcionArgumentoInvalido;

public class ValidadorParametro {

    public static void validarValorNulo(Object valor, String mensaje) {
        if(valor == null) {
            throw new ExcepcionArgumentoInvalido(mensaje);
        }
    }


    public static void validarValorVacio(String valor, String mensaje) {
        if(valor.isEmpty()) {
            throw new ExcepcionArgumentoInvalido(mensaje);
        }
    }
}
