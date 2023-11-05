package com.example.Chapter6.service;

import com.example.Chapter6.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    List<Product> getAllProduct();

    Product addProduct(Product product);

    Optional<Product> getProductByCode(Long productCode);

    Product updateProduct(Product product);

    void  deleteProduct(Long productCode);
}