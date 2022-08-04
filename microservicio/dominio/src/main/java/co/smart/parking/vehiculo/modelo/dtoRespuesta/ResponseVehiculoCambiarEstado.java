package co.smart.parking.vehiculo.modelo.dtoRespuesta;

import lombok.Getter;

@Getter
public class ResponseVehiculoCambiarEstado {

    private String mensaje;

    private String placa;

    private int capacidadActual;

    public ResponseVehiculoCambiarEstado(String mensaje, String placa, int capacidadActual) {
        this.mensaje = mensaje;
        this.placa = placa;
        this.capacidadActual = capacidadActual;
    }

}
