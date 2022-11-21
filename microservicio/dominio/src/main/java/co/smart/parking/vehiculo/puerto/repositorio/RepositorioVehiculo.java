package co.smart.parking.vehiculo.puerto.repositorio;

import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;

import java.util.List;


public interface RepositorioVehiculo {

    String guardar(Vehiculo vehiculo);
    boolean actualizar(Vehiculo vehiculo);
    boolean existePorPlaca(String placa);
    boolean eliminarPorPlaca(String placa);
}
