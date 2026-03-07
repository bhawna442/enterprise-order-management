package com.bhawnagolchha.orderms.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderItemRequest {
    private Long productId;
    private int quantity;
}
