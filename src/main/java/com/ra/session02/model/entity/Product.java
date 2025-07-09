package com.ra.session02.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "product_name", length = 100)
    private String productName;
    @Column(name = "producer", length = 100)
    private String producer;
    @Column(name = "year_making")
    private Integer yearMaking;
    @Column(name = "expire_date")
    private Date expireDate;
    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;
}
