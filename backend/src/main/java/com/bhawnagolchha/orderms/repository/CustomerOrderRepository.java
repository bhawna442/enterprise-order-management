package com.bhawnagolchha.orderms.repository;

import com.bhawnagolchha.orderms.domain.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
}
