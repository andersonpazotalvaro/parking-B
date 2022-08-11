package co.smart.parking.vehiculo.modelo.dominio;

import co.smart.parking.usuario.modelo.dominio.Usuario;
import lombok.Getter;

@Getter
public class Vehiculo {

    private final String placa;

    private final boolean activo;



    public Vehiculo(String placa, boolean activo) {
        this.placa = placa;
        this.activo = activo;

    }

    public static Vehiculo of(String placa,boolean activo,Usuario usuario) {

        //validadores de campos

        return new Vehiculo(placa,activo);
    }
}
