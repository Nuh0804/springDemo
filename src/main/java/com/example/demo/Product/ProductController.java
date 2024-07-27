package com.example.demo.Product;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {
    final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PutMapping(path = "{productId}")
    public Product updateProduct(
            @PathVariable("productId") Long productId,
            @RequestParam(required = false) Integer price,
            @RequestParam(required = false) Integer stock,
            @RequestParam(required = false) String name
    ){
        return productService.updateProduct(productId, price, stock, name);
    }
    @GetMapping(path = "{productId}")
    public ResponseEntity<?> getProductById(@PathVariable("productId") Long productId){
        return productService.getProductById(productId);
    }
    @DeleteMapping(path = "{productId}")
    public ResponseEntity<?> deleteProductById(@PathVariable("productId") Long productId){
        return productService.deleteProductById(productId);
    }
}
