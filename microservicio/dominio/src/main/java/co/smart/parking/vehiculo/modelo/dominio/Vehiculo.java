package co.smart.parking.vehiculo.modelo.dominio;


import co.smart.parking.ValidadorParametro;
import lombok.Getter;

@Getter
public class Vehiculo {

    private static final String LA_PLACA_NO_PUEDE_SER_VACIA = "La plcaca no puede ser vacia";

    private final String placa;
    private boolean activo;


    public Vehiculo(String placa, boolean activo) {
        this.placa = placa;
        this.activo= activo;

        ValidadorParametro.validarValorNoVacio(placa, LA_PLACA_NO_PUEDE_SER_VACIA);
    }

    public static Vehiculo of(String placa,boolean activo){
        return new Vehiculo(placa,activo);
    }

    public boolean isActivo() {
        return activo;
    }
}
