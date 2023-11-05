package com.example.Chapter6.repository;

import com.example.Chapter6.model.DetailOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailOrderRepository extends JpaRepository<DetailOrder, Long> {
}
