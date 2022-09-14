package co.smart.parking.vehiculo.modelo.dominio;


import lombok.Getter;

@Getter
public class Vehiculo {

    private final String placa;
    private boolean activo;


    public Vehiculo(String placa, boolean activo) {
        this.placa = placa;
        this.activo= activo;

    }

    public static Vehiculo of(String placa,boolean activo){
        return new Vehiculo(placa,activo);
    }

    public boolean isActivo() {
        return activo;
    }
}
