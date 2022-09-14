package co.smart.parking.vehiculo.entidad;

import co.smart.parking.usuario.adaptador.entidad.EntidadUsuario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name="vehiculo")
public class EntidadVehiculo {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE )
    private Long id;

    @Column
    private  String placa;

    @Column
    private boolean activo;


    public EntidadVehiculo(Long id, String placa, boolean activo) {
        this.id = id;
        this.placa = placa;
        this.activo = activo;
    }

    public EntidadVehiculo(String placa, boolean activo) {
        this.placa = placa;
        this.activo = activo;
    }

    public EntidadVehiculo(String placa) {
        this.placa = placa;
    }

    public EntidadVehiculo() {
    }

    public String getPlaca() {
        return placa;
    }

    public boolean isActivo() {
        return activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }


}
