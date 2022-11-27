package com.cursproject.DTO;

import com.cursproject.Entity.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

@Builder
public class GetUsersDTO {
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String username;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String password;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String first_name;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String last_name;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Role role;
    @JsonFormat(shape = JsonFormat.Shape.BOOLEAN)
    private Boolean isActive;
}
