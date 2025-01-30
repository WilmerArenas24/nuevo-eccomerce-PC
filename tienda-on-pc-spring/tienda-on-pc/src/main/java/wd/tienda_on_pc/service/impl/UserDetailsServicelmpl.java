package wd.tienda_on_pc.service.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import wd.tienda_on_pc.entity.SecurityUser;
import wd.tienda_on_pc.entity.User;
import wd.tienda_on_pc.repository.UserRepository;

@Service
@AllArgsConstructor

public class UserDetailsServicelmpl implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Recuperar el usuario
        User user   = userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return new SecurityUser(user);
    }
}
