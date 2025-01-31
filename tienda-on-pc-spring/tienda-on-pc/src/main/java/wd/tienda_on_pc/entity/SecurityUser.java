package wd.tienda_on_pc.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
@NoArgsConstructor
public class SecurityUser implements UserDetails {

    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Asigna el rol del usuario como una autoridad
        return Collections.singletonList(new SimpleGrantedAuthority(user.getRole()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        // Devuelve true si la cuenta no ha expirado
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Devuelve true si la cuenta no está bloqueada
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Devuelve true si las credenciales no han expirado
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Devuelve true si la cuenta está habilitada
        return true;
    }
}