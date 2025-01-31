package wd.tienda_on_pc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import wd.tienda_on_pc.repository.UserRepository;
import wd.tienda_on_pc.service.impl.UserDetailsServicelmpl;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF (opcional para APIs RESTful)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll() // Rutas públicas
                        .requestMatchers("/v1/home").authenticated() // Ruta protegida
                        .requestMatchers("/v1/admin").hasAuthority("ADMIN") // Solo para ADMIN
                        .anyRequest().authenticated() // Todas las demás rutas requieren autenticación
                )
                .formLogin(formLogin -> formLogin
                        .defaultSuccessUrl("/v1/home", true) // Redirección después de login exitoso
                        .permitAll() // Permitir acceso al formulario de login por defecto
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // URL de logout
                        .logoutSuccessUrl("/login?logout") // Redirección después de logout
                        .invalidateHttpSession(true) // Invalidar la sesión
                        .deleteCookies("JSESSIONID") // Eliminar cookies
                        .permitAll() // Permitir acceso a la funcionalidad de logout
                )
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .accessDeniedPage("/access-denied") // Página personalizada para acceso denegado (opcional)
                )
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}