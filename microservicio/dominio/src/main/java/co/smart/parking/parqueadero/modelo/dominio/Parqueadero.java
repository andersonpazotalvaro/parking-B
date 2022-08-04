package co.smart.parking.parqueadero.modelo.dominio;

import lombok.Getter;

@Getter
public class Parqueadero {

    private final int capacidadMaxima;

    private int capacidadActual;

    public Parqueadero(int capacidadMaxima, int capacidadActual) {
        this.capacidadMaxima = capacidadMaxima;
        this.capacidadActual = capacidadActual;
    }
}
