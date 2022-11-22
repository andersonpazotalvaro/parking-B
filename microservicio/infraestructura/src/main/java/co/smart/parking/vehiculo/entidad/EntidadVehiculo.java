package co.smart.parking.vehiculo.entidad;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="vehiculo")
public class EntidadVehiculo {

    @Id
    @Column(unique = true)
    private String placa;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "vehiculo")
    private List<EntidadVehiculoMovimiento> vehiculoMovimientos;

    public EntidadVehiculo() { }

    public EntidadVehiculo(String placa) {
        this.placa = placa;
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
}
