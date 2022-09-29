package co.smart.parking.auth.config;

import co.smart.parking.usuario.modelo.dominio.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;
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


    private String crearToken(Usuario usuario, Set<String> roles) {
        return Jwts.builder()
                .setSubject(usuario.getNombreUsuario())
                .claim(ROLES, roles)
                .setIssuedAt(new Date(System.currentTimeMillis()))   // Se puede mejorar para no tener que convertir los minutos
                .setExpiration(new Date(System.currentTimeMillis() + TIME_TO_EXPIRE_TOKEN_IN_MINUTES * CONVERTER_MINUTES_TO_MILLISECONDS))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }



}
