package com.example.Chapter6.service.implementasi;

import com.example.Chapter6.model.Product;
import com.example.Chapter6.repository.ProductRepository;
import com.example.Chapter6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public List<Product> getAllProduct() {
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Optional<Product> getProductByCode(Long productCode) {
        return Optional.empty();
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long productCode) {

    }
}
