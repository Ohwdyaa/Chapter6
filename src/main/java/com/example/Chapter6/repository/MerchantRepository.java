package com.example.Chapter6.repository;

import com.example.Chapter6.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {
    List<Merchant> findByOpen(boolean open);
}
