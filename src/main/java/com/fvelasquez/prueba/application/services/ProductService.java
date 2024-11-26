package com.fvelasquez.prueba.application.services;

import com.fvelasquez.prueba.domain.model.Product;
import com.fvelasquez.prueba.domain.port.ProductRepository;
import com.fvelasquez.prueba.infraestructure.adapter.ProductNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Flux<Product> getAllProducts() {
        return repository.findAll();
    }

    public Mono<Product> getProductById(String id) {
        return repository
                .findById(id)
                .switchIfEmpty(Mono.error(new ProductNotFoundException("Producto no encontrado con id " + id)))
                .onErrorResume(throwable -> {
                    // Puedes agregar lógica adicional para manejar diferentes tipos de errores si es necesario
                    if (throwable instanceof ProductNotFoundException) {
                        return Mono.error(throwable);
                    }
                    // Retornar un Mono que contiene un objeto de error personalizado para otros tipos de errores
                    return Mono.error(new ProductNotFoundException("Error al buscar producto con id " + id));
                });
    }


    public Mono<Product> createProduct(Product product) {
        return repository.save(product);
    }

    public Mono<Void> deleteProductById(String id) {
        return repository.deleteById(id);
    }

    public Mono<Product> updateProductById(String id, Product product) {
        return repository.findById(id)
                .flatMap(existingProduct -> {
                    existingProduct.setName(product.getName());
                    existingProduct.setPrice(product.getPrice());
                    existingProduct.setClase(product.getClase());
                    existingProduct.setDescuento(product.getDescuento());
                    return repository.save(existingProduct);
                });
    }

    public Mono<Product> updateProductById2(String id, Product product) {
        return repository.findById(id)
                .flatMap(existingProduct -> {
                    existingProduct.setPrice(product.getPrice());
                    existingProduct.setDescuento(product.getDescuento());
                    return repository.save(existingProduct);
                });
    }

}
