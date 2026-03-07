package com.bhawnagolchha.orderms.service;

import com.bhawnagolchha.orderms.domain.CustomerOrder;
import com.bhawnagolchha.orderms.domain.Product;
import com.bhawnagolchha.orderms.domain.User;
import com.bhawnagolchha.orderms.dto.OrderItemRequest;
import com.bhawnagolchha.orderms.repository.CustomerOrderRepository;
import com.bhawnagolchha.orderms.repository.ProductRepository;
import com.bhawnagolchha.orderms.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CustomerOrderRepository orderRepository;

    public OrderService(UserRepository userRepository,
                        ProductRepository productRepository,
                        CustomerOrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Transactional
    public CustomerOrder createOrder(Long userId, List<OrderItemRequest> items){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        CustomerOrder newOrder= new CustomerOrder(user);
        for (OrderItemRequest item : items) {

            Product product = productRepository.findById(item.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            newOrder.addItem(product, item.getQuantity());
        }

        return orderRepository.save(newOrder);
    }
}
