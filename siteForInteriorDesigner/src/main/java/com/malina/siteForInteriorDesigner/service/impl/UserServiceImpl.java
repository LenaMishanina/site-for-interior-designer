package com.malina.siteForInteriorDesigner.service.impl;

import com.malina.siteForInteriorDesigner.entity.UserEntity;
import com.malina.siteForInteriorDesigner.repository.PortfolioRepository;
import com.malina.siteForInteriorDesigner.repository.UserRepository;
import com.malina.siteForInteriorDesigner.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
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
