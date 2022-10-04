package co.smart.parking.auth.adaptador.model;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class UsuarioDetalle implements UserDetails {

    private String nombreUsuario;
    private String contrasena;
    private Set<? extends GrantedAuthority> autoridades;

    public UsuarioDetalle(String nombreUsuario, String contrasena, Set<GrantedAuthority> autoridades) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.autoridades = autoridades;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return autoridades;
    }

}
