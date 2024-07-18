package com.malina.siteForInteriorDesigner.config;

import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests(auth -> {
                    auth.requestMatchers("/**").permitAll();
//                    auth.requestMatchers("/").permitAll();
//                    auth.requestMatchers("/user").hasRole("USER");
//                    auth.requestMatchers("/admin").hasRole("ADMIN");
                })
//                .httpBasic(Customizer.withDefaults())
                .build();
    }
}
