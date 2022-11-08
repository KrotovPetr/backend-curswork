package com.cursproject.security;

import com.cursproject.Entity.User;
import io.jsonwebtoken.Claims;

import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;

@Slf4j
@Component
@AllArgsConstructor
public class JWTProvider {
    private JWTConfigurer jwtConfig;

    public String generateToken(User user) {
        Claims claims = Jwts.claims().setSubject(user.getUsername());
        claims.put("role", user.getRole());
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.from(LocalDate.now()
                        .plusDays(jwtConfig.getTokenExpiresAfterDays()))))
                .signWith(jwtConfig.getSecretKeyBean())
                .compact();
    }

    public String getUsernameFromToken(String token) {
        Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(jwtConfig.getSecretKeyBean())
                .build()
                .parseClaimsJws(token);
        return claimsJws.getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest request) {
        return request.getHeader("Authorization");
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(jwtConfig.getSecretKeyBean())
                    .build().parseClaimsJws(authToken);
            return true;
        } catch (JwtException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
        }

        return false;
    }

}