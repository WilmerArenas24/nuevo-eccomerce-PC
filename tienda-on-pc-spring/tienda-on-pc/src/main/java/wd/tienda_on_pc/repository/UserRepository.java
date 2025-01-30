package wd.tienda_on_pc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wd.tienda_on_pc.entity.User;

@Repository

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

}
