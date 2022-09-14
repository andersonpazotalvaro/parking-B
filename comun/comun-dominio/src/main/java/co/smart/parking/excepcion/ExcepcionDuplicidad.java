package co.smart.parking.excepcion;

public class ExcepcionDuplicidad extends RuntimeException {

    public ExcepcionDuplicidad(String mensaje) {
        super(mensaje);
    }
}
