package co.smart.parking.vehiculo.modelo.dominio;

import co.smart.parking.usuario.modelo.dominio.Usuario;
import lombok.Getter;

@Getter
public class Vehiculo {

    private final String placa;

    private  boolean activo;



    public Vehiculo(String placa) {
        this.placa = placa;
        this.activo= true;

    }

    public static Vehiculo of(String placa) {

        //validadores de campos

        return new Vehiculo(placa);
    }


}
