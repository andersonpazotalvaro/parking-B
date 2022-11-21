package co.smart.parking.vehiculo.modelo.dominio;

import co.smart.parking.ValidadorParametro;
import co.smart.parking.vehiculo.TipoVehiculoMovimiento;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class VehiculoMovimiento {

    private static final String EL_MOVIMIENTO_DEBE_ESTAR_ASOCIADO_A_UN_VEHICULO = "El movimiento debe estar asociado a un vehiculo";
    private static final String EL_TIPO_DE_MOVIMIENTO_NO_ES_VALIDO = "El tipo de movimiento no es valido";
    private static final String LA_FECHA_NO_ES_VALIDA_VERIFIQUE_QUE_NO_SEA_POSTERIOR_A_LA_FECHA_ACTUAL = "La fecha no es valida, verifique que no sea posterior a la fecha actual";

    private Vehiculo vehiculo;
    private TipoVehiculoMovimiento tipoVehiculoMovimiento;
    private LocalDateTime fecha;

    public VehiculoMovimiento(Vehiculo vehiculo, TipoVehiculoMovimiento tipoVehiculoMovimiento, LocalDateTime fecha) {
        ValidadorParametro.validarValorNulo(vehiculo, EL_MOVIMIENTO_DEBE_ESTAR_ASOCIADO_A_UN_VEHICULO);
        ValidadorParametro.validarValorNulo(tipoVehiculoMovimiento, EL_TIPO_DE_MOVIMIENTO_NO_ES_VALIDO);
        ValidadorParametro.validarLocalDateTime(fecha, LA_FECHA_NO_ES_VALIDA_VERIFIQUE_QUE_NO_SEA_POSTERIOR_A_LA_FECHA_ACTUAL);

        this.vehiculo = vehiculo;
        this.tipoVehiculoMovimiento = tipoVehiculoMovimiento;
        this.fecha = fecha;
    }

    public String obtenerTipoDeMovimiento() {
        return tipoVehiculoMovimiento.name();
    }
}
