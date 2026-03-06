package com.bhawnagolchha.orderms.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private BigDecimal priceAtPurchase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private CustomerOrder order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public OrderItem(CustomerOrder order, Product product, int quantity) {

        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }

        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        this.order = order;
        this.product = product;
        this.quantity = quantity;

        // Snapshot price at purchase time
        this.priceAtPurchase = product.getPrice();
    }




}
