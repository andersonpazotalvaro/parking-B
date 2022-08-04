package co.smart.parking.usuario.modelo.dominio;

import lombok.Getter;

@Getter
public class Usuario {

    private final String identificacion;

    private final String contrasena;

    private final String correo;

    private final String nombre;

    public Usuario(String identificacion, String contrasena, String correo, String nombre) {
        this.identificacion = identificacion;
        this.contrasena = contrasena;
        this.correo = correo;
        this.nombre = nombre;
    }
}
