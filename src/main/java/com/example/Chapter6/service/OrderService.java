package com.example.Chapter6.service;

import com.example.Chapter6.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {
    Order addOrder(Order order);

    List<Order> getAllOrder();

    Optional<Order> getOrderById(Long orderId);

}
