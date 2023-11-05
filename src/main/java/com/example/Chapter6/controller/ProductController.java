package com.example.Chapter6.controller;

import com.example.Chapter6.model.Product;
import com.example.Chapter6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProduct();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product addedProduct = productService.addProduct(product);
        return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
    }

    @GetMapping("/{productCode}")
    public ResponseEntity<Product> getProductByCode(@PathVariable Long productCode) {
        Optional<Product> product = productService.getProductByCode(productCode);
        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{productCode}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productCode, @RequestBody Product product) {
        product.setProductCode(productCode); // Pastikan kode produk sesuai dengan URL
        Product updatedProduct = productService.updateProduct(product);

        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{productCode}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productCode) {
        productService.deleteProduct(productCode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

//        GET /products: Endpoint untuk mendapatkan semua produk.
//        POST /products: Endpoint untuk menambahkan produk baru.
//        GET /products/{productCode}: Endpoint untuk mendapatkan produk berdasarkan kode produk.
//        PUT /products/{productCode}: Endpoint untuk memperbarui produk berdasarkan kode produk.
//        DELETE /products/{productCode}: Endpoint untuk menghapus produk berdasarkan kode produk.