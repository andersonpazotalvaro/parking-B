package co.smart.parking.usuario.modelo.dominio;

import co.smart.parking.ValidadorParametro;
import co.smart.parking.vehiculo.modelo.dominio.Vehiculo;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UsuarioPerfil {

    public static final String EL_PERFIL_DEBE_PERTENECER_A_UN_USUARIO = "El perfil debe pertenecer a un usuario";

    private Usuario usuario;
    private List<Vehiculo> vehiculos;

    public UsuarioPerfil(Usuario usuario, List<Vehiculo> vehiculos) {

        ValidadorParametro.validarValorNulo(usuario, EL_PERFIL_DEBE_PERTENECER_A_UN_USUARIO);
        ValidadorParametro.validarListaNulaYRetornarInstancia(vehiculos, new ArrayList<>());

        this.usuario = usuario;
        this.vehiculos = vehiculos;
    }
}


