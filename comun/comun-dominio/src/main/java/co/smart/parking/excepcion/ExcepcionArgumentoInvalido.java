package co.smart.parking.excepcion;

public class ExcepcionArgumentoInvalido extends RuntimeException {

    public ExcepcionArgumentoInvalido(String mensaje) {
        super(mensaje);
    }
}
