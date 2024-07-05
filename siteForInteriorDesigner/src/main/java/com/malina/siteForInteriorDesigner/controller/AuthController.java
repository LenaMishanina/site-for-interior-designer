package com.malina.siteForInteriorDesigner.controller;
import com.malina.siteForInteriorDesigner.entity.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {
    @GetMapping("/hello")
    public String hello() {
        return "hello!!!";
    }
}