package co.smart.parking.vehiculo.servicio;

import co.smart.parking.excepcion.ExcepcionDuplicidad;
import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.RespuestaVehiculo;
import co.smart.parking.vehiculo.puerto.dao.DaoVehiculo;
import co.smart.parking.vehiculo.puerto.repositorio.RepositorioVehiculo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServicioGuardarVehiculoTest {

    @Test
    public void deberiaGuardarVehiculoCorrectamente() {

        // Arrange
        var vehiculo = new Vehiculo("111", true);
        var vehiculoRespuesta = new RespuestaVehiculo(1L, vehiculo.getPlaca(), vehiculo.isActivo());
        var repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        var daoVehiculo = Mockito.mock(DaoVehiculo.class);

        var servicioGuardarVehiculo = new ServicioGuardarVehiculo(repositorioVehiculo, daoVehiculo);

        Mockito.when(repositorioVehiculo.existePorPlaca(vehiculo.getPlaca())).thenReturn(false);
        Mockito.when((daoVehiculo.obtenerVehiculoPorPlaca(vehiculo.getPlaca()))).thenReturn(vehiculoRespuesta);

        // Act
        var resultado = servicioGuardarVehiculo.ejecutar(vehiculo);

        // Assert
        assertEquals(vehiculoRespuesta, resultado);
        Mockito.verify(repositorioVehiculo, Mockito.times(1)).existePorPlaca(vehiculo.getPlaca());
        Mockito.verify(repositorioVehiculo, Mockito.times(1)).guardar(vehiculo);
        Mockito.verify(daoVehiculo, Mockito.times(1)).obtenerVehiculoPorPlaca(vehiculo.getPlaca());
    }

    @Test
    public void deberiaFallarAlValidarLaExistenciaDelVehiculo() {

        // Arrange
        var vehiculo = new Vehiculo("111", true);
        var repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        var daoVehiculo = Mockito.mock(DaoVehiculo.class);

        var servicioGuardarVehiculo = new ServicioGuardarVehiculo(repositorioVehiculo, daoVehiculo);

        Mockito.when(repositorioVehiculo.existePorPlaca(vehiculo.getPlaca())).thenReturn(true);

        // Act - Assert
        try {
            servicioGuardarVehiculo.ejecutar(vehiculo);
            fail("Se esperaba una excepción");
        } catch (Exception e) {
            assertTrue(e instanceof ExcepcionDuplicidad, "Se esperaba otra excepción");
            assertTrue(e.getMessage().contains("No se pudo guardar"), "Se esperaba otro mensaje");
        }
}
}
