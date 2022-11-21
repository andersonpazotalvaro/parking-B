package co.smart.parking.usuario.modelo.dominio;

import co.smart.parking.ValidadorParametro;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Usuario {

    public static final String SE_DEBE_INGRESAR_UN_NOMBRE_DE_USUARIO = "Se debe ingresar un nombre de usuario";
    public static final String SE_DEBE_INGRESAR_LA_CONTRASEÑA_PARA_EL_USUARIO_S = "Se debe ingresar la contraseña para el usuario %s";
    public static final String EL_CAMPO_ROLES_NO_DEBE_SER_NULO = "El campo roles no debe ser nulo";

    private String nombreUsuario;
    private String contrasena;
    private Set<String> roles;

    public Usuario(String nombreUsuario, String contrasena, Set<String> roles) {

        ValidadorParametro.validarValorVacio(nombreUsuario, SE_DEBE_INGRESAR_UN_NOMBRE_DE_USUARIO);
        ValidadorParametro.validarValorVacio(contrasena, String.format(SE_DEBE_INGRESAR_LA_CONTRASEÑA_PARA_EL_USUARIO_S, nombreUsuario));
        //ValidadorParametro.validarValorNulo(roles, EL_CAMPO_ROLES_NO_DEBE_SER_NULO);

        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.roles = ValidadorParametro.validarListaNulaYRetornarInstancia(roles, new HashSet<>());
    }
}


