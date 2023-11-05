package com.example.Chapter6.service.implementasi;

import com.example.Chapter6.model.Order;
import com.example.Chapter6.service.OrderService;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {
    @Override
    public Order addOrder(Order order) {
        return null;
    }

    @Override
    public List<Order> getAllOrder() {
        return null;
    }

    @Override
    public Optional<Order> getOrderById(Long orderId) {
        return Optional.empty();
    }
}
