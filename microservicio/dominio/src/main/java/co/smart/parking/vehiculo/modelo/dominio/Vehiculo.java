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
    private static final String EL_VEHICULO_DEBE_ESTAR_ASOCIADO_A_UN_USUARIO = "El vehiculo debe estar asociado a un usuario";

    private String placa;
    private UsuarioPerfil usuarioPerfil;


    public Vehiculo(String placa, UsuarioPerfil usuarioPerfil) {
        ValidadorParametro.validarValorVacio(placa, LA_PLACA_NO_PUEDE_SER_VACIA);
        ValidadorParametro.validarValorNulo(usuarioPerfil, EL_VEHICULO_DEBE_ESTAR_ASOCIADO_A_UN_USUARIO);

        this.placa = placa;
        this.usuarioPerfil = usuarioPerfil;
    }
}
