package com.cursproject.DTO;

import lombok.Getter;

import javax.validation.constraints.Size;

@Getter
public class UpdateUserDTO implements IUserDTO{
    @Size(min = 1, max = 255, message = "Пароль не может отсутствовать или превышать 255 символов")
    private String password;
    @Size(min = 1, max = 50, message = "Имя не может отсутствовать или превышать 50 символов")
    private String firstName;
    @Size(min = 1,max = 75, message = "Фамилия не может отсутствовать или превышать 75 символов")
    private String lastName;
}