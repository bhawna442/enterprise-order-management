package com.bhawnagolchha.orderms.repository;

import com.bhawnagolchha.orderms.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
