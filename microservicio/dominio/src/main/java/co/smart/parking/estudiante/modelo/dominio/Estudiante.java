package co.smart.parking.estudiante.modelo.dominio;

import co.smart.parking.usuario.modelo.dominio.Usuario;
import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;

public class Estudiante {

    private Usuario usuario;
    private Vehiculo vehiculo;

    public Estudiante(Usuario usuario, Vehiculo vehiculo) {
        this.usuario = usuario;
        this.vehiculo = vehiculo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
