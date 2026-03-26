package com.bhawnagolchha.orderms.exceptions;

public class OrderNotFoundException extends ResourceNotFoundException{
    public OrderNotFoundException(Long orderId){
        super("Order not found with id: "+ orderId);
    }
}
