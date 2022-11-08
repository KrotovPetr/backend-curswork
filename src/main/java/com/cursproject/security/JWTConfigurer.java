package com.cursproject.security;

import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;

@Getter
@Configuration
public class JWTConfigurer {
    @Value("${jwt.secret.access}")
    private String secretKey;

    @Value("${jwt.tokenPrefix}")
    private String tokenPrefix;

    @Value("${jwt.tokenExpiresAfterDays}")
    private Integer tokenExpiresAfterDays;

    @Bean
    public SecretKey getSecretKeyBean() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }
}