package co.smart.parking.vehiculo.puerto.repositorio;

import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;


public interface RepositorioVehiculo {


    Long guardar(Vehiculo vehiculo);
    boolean actualizar(Vehiculo vehiculo);
    boolean existePorPlaca(String placa);
    boolean eliminarPorPlaca(String placa);
}
