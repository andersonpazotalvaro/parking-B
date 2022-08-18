package co.smart.parking.usuario.adaptador.entidad;

import co.smart.parking.parqueadero.adaptador.entidad.EntidadParqueadero;
import co.smart.parking.vehiculo.adaptador.entidad.EntidadVehiculo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    @OneToOne
    @JoinColumn(name = "vehiculo_id")
    private EntidadVehiculo entidadVehiculo;

    @ManyToOne
    @JoinColumn(name = "parqueadero_id")
    private EntidadParqueadero entidadParqueadero;

    public EntidadUsuario(String identificacion, String correo, String nombre, String contrasena, EntidadVehiculo entidadVehiculo) {
        this.identificacion = identificacion;
        this.correo = correo;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.entidadVehiculo= entidadVehiculo;
    }
}
