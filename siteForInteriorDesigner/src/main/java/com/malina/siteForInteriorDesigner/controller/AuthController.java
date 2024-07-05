package com.malina.siteForInteriorDesigner.controller;
import com.malina.siteForInteriorDesigner.entity.UserEntity;
import com.malina.siteForInteriorDesigner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/register")
    public String register(@RequestBody UserEntity user) {
        service.addUser(user);
        return "User was registered successfully";
    }
}