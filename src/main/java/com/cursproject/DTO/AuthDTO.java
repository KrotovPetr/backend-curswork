package com.cursproject.DTO;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;


@Getter
@Builder
public class AuthDTO {
    @NotBlank(message = "Должно иметь хотя бы 1 символ")
    private String username;
    @NotBlank(message = "Должен иметь хотя бы 1 символ")
    private String password;
}