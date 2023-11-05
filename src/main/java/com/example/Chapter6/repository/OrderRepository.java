package com.example.Chapter6.repository;

import com.example.Chapter6.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
