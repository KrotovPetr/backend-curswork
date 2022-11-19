package com.cursproject.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

@Builder
public class GetComponentDTO {
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String type;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private int weight;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String company;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private int price;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private int amount;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String image;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private int count;
}

