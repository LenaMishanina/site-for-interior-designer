package com.malina.siteForInteriorDesigner.service;

import com.malina.siteForInteriorDesigner.entity.PortfolioEntity;
import com.malina.siteForInteriorDesigner.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity register(String first_name, String last_name, String email, String password, String password_confirm);
    List<UserEntity> findAllUser();
    UserEntity addUser(UserEntity user);
    UserEntity getUserById(long id);
    void deleteUser(long id);
    UserEntity updateUser(UserEntity user);

}
