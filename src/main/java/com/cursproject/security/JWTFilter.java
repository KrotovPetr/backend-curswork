package com.cursproject.security;

import io.jsonwebtoken.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
@AllArgsConstructor
public class JWTFilter extends OncePerRequestFilter {
    private JWTProvider provider;
    private JWTConfigurer jwtConfig;
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (token == null || !provider.validateJwtToken(token)) {
            filterChain.doFilter(request, response);
            return;
        }
        token = token.replace(jwtConfig.getTokenPrefix(), "");
        try {
            String username = provider.getUsernameFromToken(token);
            UserDetails user = userDetailsService.loadUserByUsername(username);
            Authentication authentication =
                    new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (ExpiredJwtException expEx) {
                log.error("Token expired", expEx);
            } catch (UnsupportedJwtException unsEx) {
                log.error("Unsupported jwt", unsEx);
            } catch (MalformedJwtException mjEx) {
                log.error("Malformed jwt", mjEx);
            } catch (SignatureException sEx) {
                log.error("Invalid signature", sEx);
            } catch (Exception e) {
                log.error("invalid token", e);
            }
        filterChain.doFilter(request, response);
    }


}