package com.cursproject.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "components")
public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //id - клиента
    private String type;
    private int value;
    private int price;



    //установка фамилии
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }


    //установка имени
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }


    //установка имени
    public int getPrice() {
        return value;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    //установка id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }




}