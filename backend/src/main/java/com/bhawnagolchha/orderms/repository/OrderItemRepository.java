package com.bhawnagolchha.orderms.repository;

import com.bhawnagolchha.orderms.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}

