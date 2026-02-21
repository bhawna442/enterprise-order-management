package com.bhawnagolchha.orderms.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    private LocalDateTime createdAt;
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;
}
