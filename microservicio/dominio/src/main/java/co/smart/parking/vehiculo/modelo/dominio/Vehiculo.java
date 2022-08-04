package co.smart.parking.vehiculo.modelo.dominio;

import co.smart.parking.usuario.modelo.dominio.Usuario;
import lombok.Getter;

@Getter
public class Vehiculo {

    private final String placa;

    private boolean activo;

    private final Usuario usuario;

    public Vehiculo(String placa, boolean activo, Usuario usuario) {
        this.placa = placa;
        this.activo = activo;
        this.usuario = usuario;
    }

    public static Vehiculo of(String placa,boolean activo,Usuario usuario) {

        //validadores de campos

        return new Vehiculo(placa,activo,usuario);
    }
}
