package com.crudunidad.aplicacion.service;


import com.crudunidad.aplicacion.entity.User;
import com.crudunidad.aplicacion.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.Optional;

@Service
public class UserServImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    @Transactional(readOnly = true)
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public User save(User user) {
        return null;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {

    }
}
