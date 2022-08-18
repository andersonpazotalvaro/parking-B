package co.smart.parking.parqueadero.adaptador.entidad;

import co.smart.parking.usuario.adaptador.entidad.EntidadUsuario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="parqueadero")
public class EntidadParqueadero {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE )
    private Long id;


    private int capacidadMaxima;


    private int capacidadActual;



    public EntidadParqueadero(int capacidadMaxima, int capacidadActual) {
        this.capacidadMaxima = capacidadMaxima;
        this.capacidadActual = capacidadActual;
    }
}
