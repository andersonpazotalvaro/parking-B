package co.smart.parking.vehiculo.adaptador.entidad;

import co.smart.parking.usuario.adaptador.entidad.EntidadUsuario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="vehiculo")
public class EntidadVehiculo {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE )
    private Long id;


    private  String placa;

    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private EntidadUsuario entidadUsuario;

    public EntidadVehiculo(String placa, boolean activo, EntidadUsuario entidadUsuario) {
        this.placa = placa;
        this.activo = activo;
        this.entidadUsuario = entidadUsuario;
    }
}
