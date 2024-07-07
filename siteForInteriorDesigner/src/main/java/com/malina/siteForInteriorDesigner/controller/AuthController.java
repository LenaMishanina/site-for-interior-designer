package com.malina.siteForInteriorDesigner.controller;

import com.malina.siteForInteriorDesigner.entity.UserEntity;
import com.malina.siteForInteriorDesigner.service.Login;
import com.malina.siteForInteriorDesigner.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Ref;

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
    record LoginResponse(String token) { }
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        Login login = service.login(loginRequest.email(), loginRequest.password());

        Cookie cookie = new Cookie("refresh_token", login.getRefreshToken().getToken());
        cookie.setMaxAge(3600);
        cookie.setHttpOnly(true);
        cookie.setPath("/api");

        response.addCookie(cookie);

        return new LoginResponse(login.getAccessToken().getToken());
    }
    record UserResponse(Long id, String first_name, String last_name, String email) { }
    @GetMapping("/user")
    public UserResponse user(HttpServletRequest request) {
        UserEntity user = (UserEntity) request.getAttribute("user");
        return new UserResponse(user.getId(), user.getFirst_name(), user.getLast_name(), user.getEmail());
    }
    record RefreshResponse(String token) { }
    @PostMapping("/refresh")
    public RefreshResponse refresh(@CookieValue("refresh_token") String refreshToken) {
        return new RefreshResponse(service.refreshAccess(refreshToken).getAccessToken().getToken());
    }
}