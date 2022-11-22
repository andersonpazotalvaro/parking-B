package co.smart.parking.vehiculo.modelo.dominio;


import co.smart.parking.ValidadorParametro;
import co.smart.parking.usuario.modelo.dominio.Usuario;
import co.smart.parking.usuario.modelo.dominio.UsuarioPerfil;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Vehiculo {

    private static final String LA_PLACA_NO_PUEDE_SER_VACIA = "La plcaca no puede ser vacia";

    private String placa;

    public Vehiculo(String placa) {
        ValidadorParametro.validarValorVacio(placa, LA_PLACA_NO_PUEDE_SER_VACIA);
        this.placa = placa;
    }
}
