package com.bhawnagolchha.orderms.exceptions;

public class ProductNotFoundException extends ResourceNotFoundException{
    public ProductNotFoundException(Long productId){
        super("Product with id "+productId+" not found");
    }
}
