package com.bhawnagolchha.orderms.repository;

import com.bhawnagolchha.orderms.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
