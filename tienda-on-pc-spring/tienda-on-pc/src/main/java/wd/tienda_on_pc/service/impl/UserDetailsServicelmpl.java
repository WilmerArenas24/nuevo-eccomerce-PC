package wd.tienda_on_pc.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import wd.tienda_on_pc.entity.SecurityUser;
import wd.tienda_on_pc.entity.User;
import wd.tienda_on_pc.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserDetailsServicelmpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Recuperar el usuario usando Optional
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        // Devolver un SecurityUser (implementación de UserDetails)
        return new SecurityUser(user);
    }
}