package wd.tienda_on_pc.repository;

import wd.tienda_on_pc.entity.Cart;
import wd.tienda_on_pc.entity.User;

import java.util.Optional;

public interface CartRepository {
    Optional<Cart> findByUser(User user);// Para obtener el carrito de un usuario
}
