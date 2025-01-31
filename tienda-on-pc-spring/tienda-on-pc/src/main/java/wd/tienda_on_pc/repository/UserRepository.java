package wd.tienda_on_pc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wd.tienda_on_pc.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param username El nombre de usuario a buscar.
     * @return Un Optional que contiene el usuario si existe, o vacío si no.
     */
    Optional<User> findByUsername(String username);

    /**
     * Busca un usuario por su correo electrónico.
     *
     * @param email El correo electrónico a buscar.
     * @return Un Optional que contiene el usuario si existe, o vacío si no.
     */
    Optional<User> findByEmail(String email);

    /**
     * Verifica si existe un usuario con el nombre de usuario dado.
     *
     * @param username El nombre de usuario a verificar.
     * @return true si existe, false si no.
     */
    boolean existsByUsername(String username);

    /**
     * Verifica si existe un usuario con el correo electrónico dado.
     *
     * @param email El correo electrónico a verificar.
     * @return true si existe, false si no.
     */
    boolean existsByEmail(String email);
}