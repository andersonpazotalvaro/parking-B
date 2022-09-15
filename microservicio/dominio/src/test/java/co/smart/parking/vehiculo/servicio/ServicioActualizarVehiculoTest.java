package co.smart.parking.vehiculo.servicio;

import co.smart.parking.excepcion.ExcepcionInexistente;
import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import co.smart.parking.vehiculo.puerto.repositorio.RepositorioVehiculo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class ServicioActualizarVehiculoTest {

    @Test
    public void deberiaActualizarVehiculoCorrectamente() {

        // Arrange
        var vehiculo = new Vehiculo("111", true);
        var repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);

        var servicioActualizarVehiculo = new ServicioActualizarVehiculo(repositorioVehiculo);

        Mockito.when(repositorioVehiculo.existePorPlaca(vehiculo.getPlaca())).thenReturn(true);
        Mockito.when(repositorioVehiculo.actualizar(vehiculo)).thenReturn(true);

        // Act
        var resultado = servicioActualizarVehiculo.ejecutar(vehiculo);

        // Assert
        assertTrue(resultado);
        Mockito.verify(repositorioVehiculo, Mockito.times(1)).existePorPlaca(vehiculo.getPlaca());
        Mockito.verify(repositorioVehiculo, Mockito.times(1)).actualizar(vehiculo);
    }

    @Test
    public void deberiaFallarAlValidarLaExistenciaDelVehiculo() {

        // Arrange
        var vehiculo = new Vehiculo("111", true);
        var repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);

        var servicioActualizarVehiculo = new ServicioActualizarVehiculo(repositorioVehiculo);

        Mockito.when(repositorioVehiculo.existePorPlaca(vehiculo.getPlaca())).thenReturn(false);

        // Act - Assert
        try {
            servicioActualizarVehiculo.ejecutar(vehiculo);
            fail("Se esperaba una excepción");
        } catch (Exception e) {
            assertTrue(e instanceof ExcepcionInexistente, "Se esperaba otra excepción");
            assertTrue(e.getMessage().contains("No se puede actualizar ya que el vehiculo no existe"), "Se esperaba otro mensaje");
        }
}
}
