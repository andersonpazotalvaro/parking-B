package co.smart.parking.vehiculo.servicio;

import co.smart.parking.excepcion.ExcepcionInexistente;
import co.smart.parking.vehiculo.modelo.dtoRespuesta.RespuestaVehiculo;
import co.smart.parking.vehiculo.puerto.dao.DaoVehiculo;
import co.smart.parking.vehiculo.puerto.repositorio.RepositorioVehiculo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class ServicioEliminarVehiculoTest {

    @Test
    public void deberiaEliminarVehiculoCorrectamente() {

        // Arrange
        var id = 1L;
        var placa = "111";
        var isActive = true;
        var vehiculoRespuesta = new RespuestaVehiculo(id, placa, isActive);
        var repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        var daoVehiculo = Mockito.mock(DaoVehiculo.class);

        var servicioEliminarVehiculo = new ServicioEliminarVehiculo(repositorioVehiculo, daoVehiculo);

        Mockito.when(repositorioVehiculo.existePorPlaca(placa)).thenReturn(true);
        Mockito.when(repositorioVehiculo.eliminarPorId(id)).thenReturn(true);
        Mockito.when((daoVehiculo.obtenerVehiculoPorPlaca(placa))).thenReturn(vehiculoRespuesta);

        // Act
        var resultado = servicioEliminarVehiculo.ejecutar(placa);

        // Assert
        assertTrue(resultado);
        Mockito.verify(repositorioVehiculo, Mockito.times(1)).existePorPlaca(placa);
        Mockito.verify(repositorioVehiculo, Mockito.times(1)).eliminarPorId(id);
        Mockito.verify(daoVehiculo, Mockito.times(1)).obtenerVehiculoPorPlaca(placa);
    }

    @Test
    public void deberiaFallarAlValidarLaExistenciaDelVehiculo() {

        // Arrange
        var placa = "111";
        var repositorioVehiculo = Mockito.mock(RepositorioVehiculo.class);
        var daoVehiculo = Mockito.mock(DaoVehiculo.class);

        var servicioEliminarVehiculo = new ServicioEliminarVehiculo(repositorioVehiculo, daoVehiculo);

        Mockito.when(repositorioVehiculo.existePorPlaca(placa)).thenReturn(false);

        // Act - Assert
        try {
            servicioEliminarVehiculo.ejecutar(placa);
            fail("Se esperaba una excepción");
        } catch (Exception e) {
            assertTrue(e instanceof ExcepcionInexistente, "Se esperaba otra excepción");
            assertTrue(e.getMessage().contains("No se pudo eliminar"), "Se esperaba otro mensaje");
        }
}
}
