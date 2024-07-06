package com.malina.siteForInteriorDesigner.service.impl;

import com.malina.siteForInteriorDesigner.controller.AuthController;
import com.malina.siteForInteriorDesigner.entity.UserEntity;
import com.malina.siteForInteriorDesigner.repository.UserRepository;
import com.malina.siteForInteriorDesigner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserEntity register(String first_name, String last_name, String email, String password, String password_confirm) {
        if (!Objects.equals(password, password_confirm)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "password do not match");
        }
        return repository.save(UserEntity.off(first_name, last_name, email, passwordEncoder.encode(password)));
    }
    @Override
    public List<UserEntity> findAllUser() {
        return repository.findAll();
    }

    @Override
    public UserEntity addUser(UserEntity user) {
        return repository.save(user);
    }

    @Override
    public UserEntity getUserById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteUser(long id) {
        repository.deleteById(id);
    }

    @Override
    public UserEntity updateUser(UserEntity user) {
        return repository.save(user);
    }
}
