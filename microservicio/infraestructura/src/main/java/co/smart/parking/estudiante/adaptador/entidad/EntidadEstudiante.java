package co.smart.parking.estudiante.adaptador.entidad;

import co.smart.parking.rol.adaptador.entidad.EntidadRol;
import co.smart.parking.usuario.adaptador.entidad.EntidadUsuario;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="estudiante")
public class EntidadEstudiante {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "usuario_nombre_usuario", referencedColumnName = "nombreUsuario")
    private EntidadUsuario usuario;

    public EntidadEstudiante() { }

    public EntidadEstudiante(EntidadUsuario usuario) {
        this.usuario = usuario;
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
}
