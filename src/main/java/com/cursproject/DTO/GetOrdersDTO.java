package com.cursproject.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

@Builder
public class GetOrdersDTO {
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private long id;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private int price;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String components;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private int number;
}
