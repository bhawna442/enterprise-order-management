package com.bhawnagolchha.orderms.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal price;

    public Product() {}

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}