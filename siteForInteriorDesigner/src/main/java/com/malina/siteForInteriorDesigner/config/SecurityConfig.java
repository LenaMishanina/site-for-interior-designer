package com.malina.siteForInteriorDesigner.config;

import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {
//    public InMemoryUserDetailsManager userDetailsManager() {
//return null;
//    }
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
//                .csrf(csrf -> csrf.disable())
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
