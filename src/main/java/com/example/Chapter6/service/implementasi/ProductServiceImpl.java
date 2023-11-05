package com.example.Chapter6.service.implementasi;

import com.example.Chapter6.model.Product;
import com.example.Chapter6.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> getProductByCode(Long productCode) {
        return productRepository.findById(productCode);
    }

    public Product updateProduct(Product product) {
        int rowsUpdated = productRepository.updateProductDetails(product.getProductName(), product.getPrice(), product.getProductCode());

        if (rowsUpdated > 0) {
            // Produk berhasil diperbarui
            return productRepository.findById(product.getProductCode()).orElse(null);
        } else {
            // Produk tidak ditemukan atau gagal diperbarui
            return null;
        }
    }

    public void deleteProduct(Long productCode) {
        productRepository.deleteById(productCode);
    }
}
