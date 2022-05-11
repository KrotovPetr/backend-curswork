package com.cursproject.Model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "components")
public class Components {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "weight")
    private int weight;
    @Column(name = "company")
    private String company;
    @Column(name = "price")
    private int price;
    @Column(name = "amount")
    private int amount;
    @Column(name = "image")
    private String image;
    @Column(name = "count")
    private int count;
}
