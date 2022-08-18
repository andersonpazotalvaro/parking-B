package co.smart.parking.usuario.modelo.dominio;

import co.smart.parking.parqueadero.modelo.dominio.Parqueadero;
import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import lombok.Getter;

@Getter
public class Usuario {

    private final String identificacion;

    private final String contrasena;

    private final String correo;

    private final String nombre;

    private final Vehiculo vehiculo;

    private final Parqueadero parqueadero;

    public Usuario(String identificacion, String contrasena, String correo, String nombre, Vehiculo vehiculo, Parqueadero parqueadero) {
        this.identificacion = identificacion;
        this.contrasena = contrasena;
        this.correo = correo;
        this.nombre = nombre;
        this.vehiculo = vehiculo;
        this.parqueadero = parqueadero;
    }





}


