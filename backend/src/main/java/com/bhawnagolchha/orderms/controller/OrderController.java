package com.bhawnagolchha.orderms.controller;

import com.bhawnagolchha.orderms.domain.CustomerOrder;
import com.bhawnagolchha.orderms.dto.CreateOrderRequest;
import com.bhawnagolchha.orderms.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService=orderService;
    }
    @PostMapping("/addOrder")
    public ResponseEntity<CustomerOrder> addOrder(@Valid @RequestBody CreateOrderRequest request){
        CustomerOrder order= orderService.createOrder(request.getUserId(),request.getItems());
        return ResponseEntity.ok(order);
    }
}
