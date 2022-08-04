package co.smart.parking.usuario.adaptador.entidad;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="usuario")
public class EntidadUsuario {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE )
    private Long id;

    @Column(length = 15, nullable = false)
    private String identificacion;

    @Column(length = 50, nullable = false)
    private String correo;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 10, nullable = false)
    private String contrasena;

    public EntidadUsuario(String identificacion, String correo, String nombre, String contrasena) {
        this.identificacion = identificacion;
        this.correo = correo;
        this.nombre = nombre;
        this.contrasena = contrasena;
    }
}
