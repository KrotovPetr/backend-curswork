package com.cursproject.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import ru.cursproject.service.UserService;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

     /*
    Класс в Spring, отвечающий за безопасноть и роутинг. Здесь закладываются основы и правила переходов по страницам,
     например, нельзя зайти в личный кабинет, не вводив пароль и т.д. Пароль шифруется и сравнивает с БД, основанной на
     postgreSQL. Класс описывает конфигурацию.
     */

    //Шифровка
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    //взаимодействия со страницей
    //.disable - отключение csrf
    //.permitAll - разрешение к страницам без процесса авторизации
    //.antMatchers - базовые страницы
    //.formlogin - форма заполнения логина
    //.and() - security связка
    //.loginPage - страница входа в аккаунт
    //.failureURL - если что-то пошло не по плану
    //.defaltSuccessURL - дефолтный адрес перехода страницы
    // далее идут необходимые повторения под страницу logout
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/login", "/registration", "/")
                .permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .defaultSuccessUrl("/", false)
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .permitAll()
                .and()
                .rememberMe();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }
}

