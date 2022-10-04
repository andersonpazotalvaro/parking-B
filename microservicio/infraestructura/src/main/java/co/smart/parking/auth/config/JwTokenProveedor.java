package co.smart.parking.auth.config;

import co.smart.parking.usuario.modelo.dominio.Usuario;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class JwTokenProveedor {

    private static final String ROLES = "roles";
    private static final int TIME_TO_EXPIRE_TOKEN_IN_MINUTES = 10;
    private static final int CONVERTER_MINUTES_TO_MILLISECONDS = 5000;

    @Value("${jwt.secret}")
    private String secret;


    public String generarToken(Usuario usuario) {

        var roles = usuario.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority(rol).getAuthority()).collect(Collectors.toSet());
        return crearToken(usuario, roles);
    }

    public String obtenerNombreUsuarioDeToken(String token) {
        return obtenerDataDesdeRolesPorToken(token, Claims::getSubject);
    }

    public Date obtenerFechaExpedicionToken(String token) {
        return obtenerDataDesdeRolesPorToken(token, Claims::getIssuedAt);
    }

    public Date obtenerFechaVencimientoToken(String token) {
        return obtenerDataDesdeRolesPorToken(token, Claims::getExpiration);
    }

    public void validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token);

        }catch (MalformedJwtException e) {
            //throw new ExceptionJwt(ExceptionMessages.MESSAGE_TOKEN_MALFORMED);
        }catch (ExpiredJwtException e) {
            //throw new ExceptionJwt(ExceptionMessages.MESSAGE_TOKEN_EXPIRED);
        }catch (UnsupportedJwtException e) {
            //throw new ExceptionJwt(ExceptionMessages.MESSAGE_TOKEN_UNSOPPORTED);
        }catch (IllegalArgumentException e) {
            //throw new ExceptionJwt(ExceptionMessages.MESSAGE_TOKEN_EMPTY);
        }catch (SignatureException e) {
            //throw new ExceptionJwt(ExceptionMessages.MESSAGE_BADLY_SIGNED_TOKEN);
        }catch (Exception e) {
            //throw new ExceptionJwt(ExceptionMessages.MESSAGE_TOKEN_INVALID);
        }
    }


    private String crearToken(Usuario usuario, Set<String> roles) {
        return Jwts.builder()
                .setSubject(usuario.getNombreUsuario())
                .claim(ROLES, roles)
                .setIssuedAt(new Date(System.currentTimeMillis()))   // Se puede mejorar para no tener que convertir los minutos
                .setExpiration(new Date(System.currentTimeMillis() + TIME_TO_EXPIRE_TOKEN_IN_MINUTES * CONVERTER_MINUTES_TO_MILLISECONDS))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }


    private <T> T obtenerDataDesdeRolesPorToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = obtenerTodosLosRolesPorToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims obtenerTodosLosRolesPorToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

}
