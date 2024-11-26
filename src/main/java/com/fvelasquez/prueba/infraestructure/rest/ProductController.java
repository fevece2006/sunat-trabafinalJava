package com.fvelasquez.prueba.infraestructure.rest;

import com.fvelasquez.prueba.application.services.ProductService;
import com.fvelasquez.prueba.domain.model.Product;
import com.fvelasquez.prueba.infraestructure.rules.ProductRules;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public Flux<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public Mono<Product> getProductById(@PathVariable String id) {
        return service.getProductById(id);
    }

    @PostMapping
    public Mono<Product> createProduct(@RequestBody Product product) {

        ProductRules productRules = new ProductRules();
        productRules.applyRules(product);

        return service.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProductById(@PathVariable String id) {
        return service.deleteProductById(id);
    }

    @PutMapping("/{id}")
    public Mono<Product> updateProductById(@PathVariable String id, @RequestBody Product product) {
        return service.updateProductById(id, product);
    }

    @PatchMapping("/{id}")
    public Mono<Product> updateProductById2(@PathVariable String id, @RequestBody Product product) {
        return service.updateProductById2(id, product);
    }

}
