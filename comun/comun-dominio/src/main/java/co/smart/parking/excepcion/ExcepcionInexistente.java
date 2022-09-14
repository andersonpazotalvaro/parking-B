package co.smart.parking.excepcion;

public class ExcepcionInexistente extends RuntimeException {

    public ExcepcionInexistente(String mensaje) {
        super(mensaje);
    }
}
