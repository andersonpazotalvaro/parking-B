package co.smart.parking.rol.adaptador;

import co.smart.parking.Role;
import co.smart.parking.rol.adaptador.entidad.EntidadRol;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class MapperRol {

    public Set<String> crearRespuestas(Set<EntidadRol> entidadesRol) {
        var roles = new HashSet<String>();

        entidadesRol.forEach(rol -> {
            roles.add(crearRespuesta(rol));
        });

        return roles;
    }

    public Set<EntidadRol> crearEntidades(Set<String> roles) {
        var entidades = new HashSet<EntidadRol>();

        roles.forEach(rol -> {
            entidades.add(crearEntidad(rol));
        });

        return entidades;
    }


    public Set<GrantedAuthority> crearAutoridades(Set<String> roles) {
        var autoridades = new HashSet<GrantedAuthority>();

        roles.forEach(rol -> {
            autoridades.add(crearAutoridad(rol));
        });

        return autoridades;
    }

    public String crearRespuesta(EntidadRol entidadRol) {
        return entidadRol.getRol().name();
    }
    public EntidadRol crearEntidad(String rol) {
        return new EntidadRol(Role.valueOf(rol));
    }
    public GrantedAuthority crearAutoridad(String rol) {
        return new SimpleGrantedAuthority(rol);
    }
}
