package com.bhawnagolchha.orderms.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

@Getter
public class CreateOrderRequest {
    @NotNull
    private Long userId;

    @NotNull
    private List<OrderItemRequest> items;
}
