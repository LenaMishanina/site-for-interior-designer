package com.malina.siteForInteriorDesigner.controller;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.malina.siteForInteriorDesigner.entity.UserEntity;
import com.malina.siteForInteriorDesigner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestController
@RequestMapping("/api")
public class AuthController {
    public final UserService service;
    @Autowired
    public AuthController(UserService service) {
        this.service = service;
    }
    @GetMapping("/hello")
    public String hello() {
        return "hello!!!";
    }
    record RegisterRequest(String first_name, String last_name, String email, String password, String password_confirm) { }
    record RegisterResponse(Long id, String first_name, String last_name, String email) { }
    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest) {
        UserEntity user = service.register(
                registerRequest.first_name(),
                registerRequest.last_name(),
                registerRequest.email(),
                registerRequest.password(),
                registerRequest.password_confirm()
        );
        return new RegisterResponse(user.getId(), user.getFirst_name(), user.getLast_name(), user.getEmail());
    }
    record LoginRequest(String email, String password) { }
    record LoginResponse(Long id, String first_name, String last_name, String email) { }
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        UserEntity user = service.login(loginRequest.email(), loginRequest.password());
        return new LoginResponse(user.getId(), user.getFirst_name(), user.getLast_name(), user.getEmail());
    }
}