package co.smart.parking.vehiculo.domain;

import co.smart.parking.excepcion.ExcepcionArgumentoInvalido;
import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VehiculoTest {

    @Test
    public void deberiaCrearCorrectamenteVehiculo() {

        // Arrange - Act
        var vehiculo = new Vehiculo("111", true);

        // Assert
        assertEquals("111", vehiculo.getPlaca());
        assertTrue(vehiculo.isActivo());
    }

    @Test
    public void deberiaFallarAlCrearVehiculoConPlacaVacia() {

        // Arrange
        var placa = "";
        var activo = true;

        // Act - Assert
        try {
            var vehiculo = new Vehiculo(placa, activo);
        } catch (Exception e) {
            assertTrue(e instanceof ExcepcionArgumentoInvalido, "Se esperaba otra excepción");
            assertTrue(e.getMessage().contains("La plcaca no puede ser vacia"));
        }

    }
}
