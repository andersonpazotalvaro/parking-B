package co.smart.parking.vehiculo.entidad;

import co.smart.parking.usuario.adaptador.entidad.EntidadUsuarioPerfil;
import co.smart.parking.vehiculo.modelo.dominio.VehiculoMovimiento;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="vehiculo")
public class EntidadVehiculo {

    @Id
    @Column(unique = true)
    private String placa;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "vehiculo")
    private List<EntidadVehiculoMovimiento> vehiculoMovimientos;

    @ManyToOne
    @JoinColumn(name="usuario_perfil_nombre_usuario", nullable=false)
    private EntidadUsuarioPerfil entidadUsuarioPerfil;


    public EntidadVehiculo() { }

    public EntidadVehiculo(String placa, EntidadUsuarioPerfil entidadUsuarioPerfil) {
        this.placa = placa;
        this.entidadUsuarioPerfil = entidadUsuarioPerfil;
    }


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public List<EntidadVehiculoMovimiento> getVehiculoMovimientos() {
        return vehiculoMovimientos;
    }

    public void setVehiculoMovimientos(List<EntidadVehiculoMovimiento> vehiculoMovimientos) {
        this.vehiculoMovimientos = vehiculoMovimientos;
    }

    public EntidadUsuarioPerfil getEntidadUsuarioPerfil() {
        return entidadUsuarioPerfil;
    }

    public void setEntidadUsuarioPerfil(EntidadUsuarioPerfil entidadUsuarioPerfil) {
        this.entidadUsuarioPerfil = entidadUsuarioPerfil;
    }
}
