package co.smart.parking.auth.adaptador;

import co.smart.parking.auth.config.JwTokenProveedor;
import co.smart.parking.excepcion.ExcepcionCredencialesIncorrectas;
import co.smart.parking.jwToken.modelo.dto.RespuestaJwToken;
import co.smart.parking.usuario.modelo.dominio.Usuario;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Auth {

    private final AuthenticationManager authenticationManager;
    private final JwTokenProveedor jwTokenProvider;

    public Auth(AuthenticationManager authenticationManager, JwTokenProveedor jwTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwTokenProvider = jwTokenProvider;
    }

    public RespuestaJwToken login(Usuario usuario) {
        try {

            var usuarioAuth = new UsernamePasswordAuthenticationToken(usuario.getNombreUsuario(), usuario.getContrasena());
            var auth = this.authenticationManager.authenticate(usuarioAuth);
            var token = this.jwTokenProvider.generarToken(usuario);
            SecurityContextHolder.getContext().setAuthentication(auth);
            return new RespuestaJwToken(token);

        } catch (BadCredentialsException e) {
            throw new ExcepcionCredencialesIncorrectas("Credenciales de autenticación incorrectas");
        }
    }
}
