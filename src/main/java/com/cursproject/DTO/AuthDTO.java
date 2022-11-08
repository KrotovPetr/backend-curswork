package com.cursproject.DTO;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.NotBlank;


@Getter
@Builder
public class AuthDTO {
    @NotBlank(message = "Почта (имя пользователя) не может быть пустой")
    private String username;
    @NotBlank(message = "Пароль не может быть пустым")
    private String password;
}