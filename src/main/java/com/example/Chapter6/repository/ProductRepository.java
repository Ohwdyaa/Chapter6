package com.example.Chapter6.repository;

import com.example.Chapter6.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.productName = :productName, p.price = :price WHERE p.productCode = :productCode")
    int updateProductDetails(@Param("productName") String productName, @Param("price") double price, @Param("productCode") Long productCode);
}
