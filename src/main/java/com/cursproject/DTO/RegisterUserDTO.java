package com.cursproject.DTO;

import com.cursproject.Entity.Role;
import com.cursproject.Entity.User;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Builder
public class RegisterUserDTO implements IUserDTO {
    @NotBlank(message = "Почта (имя пользователя) не может быть пустой")
    @Size(max = 50, message = "Почта не может превышать 50 символов")
    private String username;
    @NotBlank(message = "Пароль не может быть пустым")
    @Size(max = 255, message = "Пароль не может превышать 255 символов")
    private String password;
    @NotBlank(message = "Имя не может быть пустым")
    @Size(max = 50, message = "Имя не может превышать 50 символов")
    private String firstName;
    @NotBlank(message = "Фамилия не может быть пустой")
    @Size(max = 75, message = "Фамилия не может превышать 75 символов")
    private String lastName;


    public User toUser() {
        return User.builder().username(username).password(password)
                .firstName(firstName).lastName(lastName).isActive(true)
                .roles(Role.USER).build();
    }
}