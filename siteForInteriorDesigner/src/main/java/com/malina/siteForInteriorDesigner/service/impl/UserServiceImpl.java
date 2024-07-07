package com.malina.siteForInteriorDesigner.service.impl;

import com.malina.siteForInteriorDesigner.controller.AuthController;
import com.malina.siteForInteriorDesigner.entity.UserEntity;
import com.malina.siteForInteriorDesigner.repository.UserRepository;
import com.malina.siteForInteriorDesigner.service.Login;
import com.malina.siteForInteriorDesigner.service.Token;
import com.malina.siteForInteriorDesigner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    private final String accessTokenSecret;
    private final String refreshTokenSecret;

    @Autowired
    public UserServiceImpl(
            UserRepository repository,
            PasswordEncoder passwordEncoder,
            @Value("${application.security.access-token-secret}") String accessTokenSecret,
            @Value("${application.security.refresh-token-secret}") String refreshTokenSecret) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.accessTokenSecret = accessTokenSecret;
        this.refreshTokenSecret = refreshTokenSecret;
    }

    @Override
    public UserEntity register(String first_name, String last_name, String email, String password, String password_confirm) {
        if (!Objects.equals(password, password_confirm)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "password do not match");
        }
        return repository.save(UserEntity.off(first_name, last_name, email, passwordEncoder.encode(password)));
    }

    @Override
    public Login login(String email, String password) {
        System.out.println("USER_BY_EMAIL : " + repository.findByEmail(email));
        UserEntity user = repository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid credentials"));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid credentials");
        }
        return Login.of(user.getId(), accessTokenSecret, refreshTokenSecret);
    }

    @Override
    public UserEntity getUserFromToken(String token) {
        return repository.findById(Token.from(token, accessTokenSecret))
                .orElseThrow(() -> new UsernameNotFoundException("ERRoR UserServiceImpl"));
    }

    @Override
    public Login refreshAccess(String refreshToken) {
        Long userId = Token.from(refreshToken, refreshTokenSecret);
        Login login = Login.of(userId, accessTokenSecret, Token.of(refreshToken));
        return login;
    }

    @Override
    public List<UserEntity> findAllUser() {
        return null;
//        return repository.findAll();
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
