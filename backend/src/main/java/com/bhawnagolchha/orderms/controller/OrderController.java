package com.bhawnagolchha.orderms.controller;

import com.bhawnagolchha.orderms.domain.CustomerOrder;
import com.bhawnagolchha.orderms.dto.CreateOrderRequest;
import com.bhawnagolchha.orderms.dto.OrderResponse;
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
        CustomerOrder order= orderService.createOrder(request.getUserId(),request.getItems());
        OrderResponse response = orderMapper.toOrderResponse(order);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id) {

        CustomerOrder order = orderService.getOrderById(id);

        OrderResponse response = orderMapper.toOrderResponse(order);

        return ResponseEntity.ok(response);
    }
}
