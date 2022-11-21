package co.smart.parking.vehiculo.entidad;

import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="vehiculoMovimiento")
public class EntidadVehiculoMovimiento {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehiculo_placa", nullable = false, updatable = false)
    private EntidadVehiculo vehiculo;

    @Column
    private String tipoMovimiento;

    @Column
    private LocalDateTime fecha;


    public EntidadVehiculoMovimiento() { }

    public EntidadVehiculoMovimiento(Long id, EntidadVehiculo vehiculo, String tipoMovimiento, LocalDateTime fecha) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.tipoMovimiento = tipoMovimiento;
        this.fecha = fecha;
    }

    public EntidadVehiculoMovimiento(EntidadVehiculo vehiculo, String tipoMovimiento, LocalDateTime fecha) {
        this.vehiculo = vehiculo;
        this.tipoMovimiento = tipoMovimiento;
        this.fecha = fecha;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public EntidadVehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(EntidadVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }
}
