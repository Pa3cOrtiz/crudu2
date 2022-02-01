package com.crudunidad.aplicacion.service;


import com.crudunidad.aplicacion.entity.User;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Optional;

public interface UserService {

    public Iterable <User> findAll();

    public Page<User> findAll(Pageable pageable);

    public Optional<User> findById(Long id);

    public User save(User user);

    public void deleteById(Long id);

}
