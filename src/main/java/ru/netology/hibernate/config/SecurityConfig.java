package ru.netology.hibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/persons/public-info").permitAll()  // Без авторизации
                        .anyRequest().authenticated()                        // Все остальные — с авторизацией
                )
                .formLogin(form -> form
                        .loginPage("/login")                                // Стандартная форма
                        .permitAll()
                )
                .logout(logout -> logout.permitAll());

        return http.build();
    }
}