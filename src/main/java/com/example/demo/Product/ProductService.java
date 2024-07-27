package com.example.demo.Product;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {
    final private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product){
        Optional<Product> availableProduct = productRepository.findById(product.getId());
        if (availableProduct.isPresent()){
            throw new IllegalStateException("product exists");
        }
        productRepository.save(product);
        return product;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Transactional
    public Product updateProduct(Long productId, Integer price, Integer stock, String name) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalStateException("no such product"));
        Optional<Product> optionalProduct = productRepository.getProductsByName(name);
        if (optionalProduct.isPresent()){
            throw new IllegalStateException("product exists. Hence change name");
        }
        if (price !=null && !Objects.equals(price, product.getPrice())){
            product.setPrice(price);
        }
        if(stock != null && !Objects.equals(stock, product.getStock())){
            product.setStock(stock);
        }
        if (name!= null && !Objects.equals(name, product.getName())){
            product.setName(name);
        }
        return product;
    }

    public ResponseEntity<?> getProductById(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            // Return the product with HTTP status 200 OK
            return ResponseEntity.ok(optionalProduct.get());
        } else {
            // Return HTTP status 404 Not Found if the product is not present
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<?> deleteProductById(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()){
            productRepository.deleteById(productId);
            return ResponseEntity.ok("successful");
        }
        return ResponseEntity.notFound().build();
    }
}
