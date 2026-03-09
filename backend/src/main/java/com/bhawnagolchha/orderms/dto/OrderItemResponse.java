package com.bhawnagolchha.orderms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class OrderItemResponse {
    private Long id;
    private Integer quantity;
    private BigDecimal price;
}
