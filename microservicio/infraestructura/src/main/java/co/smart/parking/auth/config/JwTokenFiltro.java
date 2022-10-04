package co.smart.parking.auth.config;

import co.smart.parking.auth.adaptador.CargaUsuario;
import co.smart.parking.jwToken.modelo.dto.RespuestaJwToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwTokenFiltro extends OncePerRequestFilter {

    private final JwTokenProveedor jwTokenProveedor;
    private final CargaUsuario cargaUsuario;

    public JwTokenFiltro(JwTokenProveedor jwTokenProveedor, CargaUsuario cargaUsuario) {
        this.jwTokenProveedor = jwTokenProveedor;
        this.cargaUsuario = cargaUsuario;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var jwToken = getToken(request);

        if(jwToken != null) {
            this.jwTokenProveedor.validateToken(jwToken.getToken());
            var userName = this.jwTokenProveedor.obtenerNombreUsuarioDeToken(jwToken.getToken());
            var user = this.cargaUsuario.loadUserByUsername(userName);
            var userAuth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(userAuth);
        }

        filterChain.doFilter(request, response);
    }

    private RespuestaJwToken getToken(HttpServletRequest request) {
        var header = request.getHeader("Authorization");
        if(header != null && header.startsWith("Bearer")) {
            var token = header.replace("Bearer ", "");
            return new RespuestaJwToken(token);
        }else return null;
    }

}
