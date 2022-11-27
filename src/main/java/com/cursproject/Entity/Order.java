package com.cursproject.Entity;


import com.cursproject.DTO.GetOrdersDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "price")
    private int price;
    @Column(name = "email")
    private String email;
    @Column(name = "components")
    private String components;
    @Column(name = "number")
    private int number;

    public GetOrdersDTO toDTO() {
        return GetOrdersDTO.builder().id(this.id).price(this.price).email(this.email)
                .components(this.components).number(this.number).build();
    }
}