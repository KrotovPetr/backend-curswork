package com.cursproject.DTO;

import lombok.Getter;

import javax.validation.constraints.Size;


@Getter
public class UpdateComponentDTO {
    @Size(min = 1, max = 255, message = "Пароль не может отсутствовать или превышать 255 символов")
    private String name;
    @Size(min = 1, max = 255, message = "Пароль не может отсутствовать или превышать 255 символов")
    private String type;
    @Size(min = 1, max = 255, message = "Пароль не может отсутствовать или превышать 255 символов")
    private int weight;
    @Size(min = 1, max = 255, message = "Пароль не может отсутствовать или превышать 255 символов")
    private String company;
    @Size(min = 1, max = 255, message = "Пароль не может отсутствовать или превышать 255 символов")
    private int price;
    @Size(min = 1, max = 255, message = "Пароль не может отсутствовать или превышать 255 символов")
    private int amount;
    @Size(min = 1, max = 255, message = "Пароль не может отсутствовать или превышать 255 символов")
    private String image;
    @Size(min = 1, max = 255, message = "Пароль не может отсутствовать или превышать 255 символов")
    private int count;
}
