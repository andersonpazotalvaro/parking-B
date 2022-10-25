package co.smart.parking.usuario.adaptador.entidad;

import co.smart.parking.rol.adaptador.entidad.EntidadRol;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="usuario")
public class EntidadUsuario {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE )
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String nombreUsuario;

    @Column(nullable = false)
    private String contrasena;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_rol",
            joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<EntidadRol> roles;


    public EntidadUsuario() { }

    public EntidadUsuario(String nombreUsuario, String contrasena, Set<EntidadRol> roles) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Set<EntidadRol> getRoles() {
        return roles;
    }

    public void setRoles(Set<EntidadRol> roles) {
        this.roles = roles;
    }
}
