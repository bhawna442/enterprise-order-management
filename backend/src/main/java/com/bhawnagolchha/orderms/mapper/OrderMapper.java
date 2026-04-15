package com.bhawnagolchha.orderms.mapper;

import com.bhawnagolchha.orderms.domain.Order;
import com.bhawnagolchha.orderms.domain.OrderItem;
import com.bhawnagolchha.orderms.dto.response.OrderItemResponse;
import com.bhawnagolchha.orderms.dto.response.OrderResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public OrderItemResponse toOrderItemResponse(OrderItem item) {
        return new OrderItemResponse(
                item.getProduct().getId(),
                item.getQuantity(),
                item.getPriceAtPurchase()
        );
    }

    public OrderResponse toOrderResponse(Order order) {

        List<OrderItemResponse> items = order.getOrderItems()
                .stream()
                .map(this::toOrderItemResponse)
                .collect(Collectors.toList());

        return new OrderResponse(
                order.getOrderId(),
                order.calculateTotal(),
                order.getCreatedAt(),
                items

        );
    }
}
