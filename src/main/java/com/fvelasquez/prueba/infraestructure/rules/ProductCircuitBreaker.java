package com.fvelasquez.prueba.infraestructure.rules;

import com.fvelasquez.prueba.domain.model.Product;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.reactor.circuitbreaker.operator.CircuitBreakerOperator;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class ProductCircuitBreaker {

    private final CircuitBreaker circuitBreaker;

    public ProductCircuitBreaker() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofMillis(1000))
                .build();
        circuitBreaker = CircuitBreaker.of("productService", config);
    }

    public Mono<Product> getProductByIdWithCircuitBreaker(String id) {
        return Mono.fromCallable(() -> getProductById(id))
                .transformDeferred(CircuitBreakerOperator.of(circuitBreaker));
    }

/*
    private Product getProductById(String id) {
        // Implementa tu llamada al servicio aquí
        return null;
    }

 */

    private Product getProductById(String id) {
        // Simulación de una llamada al servicio para obtener un producto por su ID
        // En un entorno real, esta sería la llamada al servicio real que obtiene el producto de la base de datos u otra fuente
        if ("existingProductId".equals(id)) {
            // Simular la obtención de un producto existente
            return new Product("existingProductId", 100.00, "Vehiculo", 20.00);
        } else {
            // Simular el escenario donde el producto no se encuentra
            throw new RuntimeException("Product not found");
        }
    }


}
