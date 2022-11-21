package co.smart.parking.usuario.adaptador.entidad;

import co.smart.parking.vehiculo.entidad.EntidadVehiculo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="usuario_perfil")
public class EntidadUsuarioPerfil {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "usuario_nombre_usuario", referencedColumnName = "nombreUsuario")
    private EntidadUsuario usuario;

    @OneToMany()
    private List<EntidadVehiculo> vehiculos;


    public EntidadUsuarioPerfil() { }

    public EntidadUsuarioPerfil(EntidadUsuario usuario, List<EntidadVehiculo> vehiculos) {
        this.usuario = usuario;
        this.vehiculos = vehiculos;
    }

    public Long getId() {
        return id;
    }

    public EntidadUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(EntidadUsuario usuario) {
        this.usuario = usuario;
    }

    public List<EntidadVehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<EntidadVehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
