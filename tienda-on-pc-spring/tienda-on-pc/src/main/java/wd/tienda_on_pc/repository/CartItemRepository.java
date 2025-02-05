package wd.tienda_on_pc.repository;

import wd.tienda_on_pc.entity.Cart;
import wd.tienda_on_pc.entity.CartItem;
import wd.tienda_on_pc.entity.Producto;

import java.util.Optional;

public interface CartItemRepository {
    Optional<CartItem> findByCartAndProduct(Cart cart, Producto producto);// Para evitar duplicados
}
