package com.cursproject.config;

import com.cursproject.Entity.Permission;
import com.cursproject.security.JWTFilter;
import com.cursproject.security.JwtAuthenticationEntryPoint;
import com.cursproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.PATCH;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JWTFilter jwtTokenFilter;
    private final UserService userService;

    @Autowired
    public WebSecurityConfig(JWTFilter filter, JwtAuthenticationEntryPoint entryPoint,
                             PasswordEncoder passwordEncoder, UserService userService) {
        this.jwtTokenFilter = filter;
        this.jwtAuthenticationEntryPoint = entryPoint;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests() //Запрос на вход
                .antMatchers("/auth/**").permitAll()
                .antMatchers(POST, "/component/**").hasAuthority(Permission.ADMIN_PERMISSION.getPermission())
                .antMatchers(GET, "/order/**").hasAuthority(Permission.ADMIN_PERMISSION.getPermission())
                .antMatchers(PUT, "/component/**").hasAuthority(Permission.ADMIN_PERMISSION.getPermission())
                .antMatchers(PATCH, "/component/**").hasAuthority(Permission.ADMIN_PERMISSION.getPermission())
                .antMatchers(DELETE, "/component/**", "/order/**").hasAuthority(Permission.ADMIN_PERMISSION.getPermission())
                .anyRequest().authenticated()
                .and().exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}