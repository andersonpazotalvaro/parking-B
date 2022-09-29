package co.smart.parking.excepcion;

public class ExcepcionCredencialesIncorrectas extends RuntimeException {

    public ExcepcionCredencialesIncorrectas(String message) {
        super(message);
    }
}
