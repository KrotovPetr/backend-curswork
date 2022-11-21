package com.cursproject.DTO;

import lombok.Getter;

import javax.validation.constraints.Size;


@Getter
public class UpdateComponentDTO {
    @Size(min = 1, max = 255, message = "Пароль не может отсутствовать или превышать 255 символов")
    private String name;
    @Size(min = 1, max = 255, message = "Пароль не может отсутствовать или превышать 255 символов")
    private String type;
    private int weight;
    @Size(min = 1, max = 255, message = "Пароль не может отсутствовать или превышать 255 символов")
    private String company;
    private int price;
    private int amount;
    @Size(min = 1, max = 255, message = "Пароль не может отсутствовать или превышать 255 символов")
    private String image;
    private int count;
}
