package com.example.zegel.devices.repositorio;

import com.example.zegel.devices.entidades.Seguridad.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositorio  extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
