package com.malina.siteForInteriorDesigner.interceptor;

import com.malina.siteForInteriorDesigner.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {
    private final UserService service;

    public AuthorizationInterceptor(UserService service) {
        this.service = service;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorizationHandler = request.getHeader("Authorization");
        if (authorizationHandler == null || !authorizationHandler.startsWith("Bearer ")) {
            throw new Exception("error AuthorizationInterceptor");
        }
        request.setAttribute("user", service.getUserFromToken(authorizationHandler.substring(7)));

        return true;
    }
}
