package wd.tienda_on_pc.service.impl;

import wd.tienda_on_pc.entity.User;

public interface IUserService {
    User saveUser(User user);
    User findByUsername(String username);
    User findByEmail (String email);
}
