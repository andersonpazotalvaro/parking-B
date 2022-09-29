package co.smart.parking.usuario.adaptador.entidad;

import co.smart.parking.rol.adaptador.entidad.EntidadRol;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="usuario")
public class EntidadUsuario {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE )
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String nombreUsuario;

    @Column(length = 10, nullable = false)
    private String contrasena;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(name = "usuario_rol",
            joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<EntidadRol> roles;



    public EntidadUsuario(String nombreUsuario, String contrasena, Set<EntidadRol> roles) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.roles = roles;
    }
}
