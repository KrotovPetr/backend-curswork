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
    @NotBlank(message = "Логин должен сожержать хотя бы 1 символ")
    @Size(max = 50, message = "Превышен лимит в 50 символов")
    private String username;
    @NotBlank(message = "Пароль не может быть пустым")
    @Size(max = 255, message = "Превышен лимит в 255 символов")
    private String password;
    @NotBlank(message = "Имя не может быть пустым")
    @Size(max = 50, message = "Превышен лимит в 50 символов")
    private String firstName;
    @NotBlank(message = "Фамилия не может быть пустой")
    @Size(max = 75, message = "Превышен лимит в 75 символов")
    private String lastName;


    public User toUser() {
        return User.builder().username(username).password(password)
                .firstName(firstName).lastName(lastName).isActive(true)
                .roles(Role.USER).build();
    }
}