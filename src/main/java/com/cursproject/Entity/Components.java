package com.cursproject.Entity;


import com.cursproject.DTO.GetComponentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "components")
@NoArgsConstructor
@AllArgsConstructor
@Builder
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


    public GetComponentDTO toDTO() {
        return GetComponentDTO.builder().id(this.id).name(this.name).type(this.type)
                .weight(this.weight).company(this.company)
                .price(this.price).amount(this.amount)
                .image(this.image).count(this.count).build();
    }
}
