package com.bhawnagolchha.orderms.controller;

import com.bhawnagolchha.orderms.domain.Order;
import com.bhawnagolchha.orderms.dto.request.CreateOrderRequest;
import com.bhawnagolchha.orderms.dto.response.OrderResponse;
import com.bhawnagolchha.orderms.mapper.OrderMapper;
import com.bhawnagolchha.orderms.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public OrderController(OrderService orderService,OrderMapper orderMapper){
        this.orderService=orderService;
        this.orderMapper=orderMapper;
    }
    @PostMapping("/addOrder")
    public ResponseEntity<OrderResponse> addOrder(@Valid @RequestBody CreateOrderRequest request){
        Order order= orderService.createOrder(request.getUserId(),request.getItems());
        OrderResponse response = orderMapper.toOrderResponse(order);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id) {

        Order order = orderService.getOrderById(id);

        OrderResponse response = orderMapper.toOrderResponse(order);

        return ResponseEntity.ok(response);
    }
}
