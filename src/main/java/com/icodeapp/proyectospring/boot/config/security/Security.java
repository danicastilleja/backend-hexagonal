package com.icodeapp.proyectospring.boot.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Security {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(
                csrf -> csrf.disable()
                 ).authorizeHttpRequests(
                auth->{
                    auth.requestMatchers("/autores").permitAll()
                            .anyRequest().authenticated();

                }
        ).httpBasic(Customizer.withDefaults())
                .build();
    }
}
