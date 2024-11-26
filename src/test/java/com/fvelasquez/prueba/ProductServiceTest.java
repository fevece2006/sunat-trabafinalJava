package com.fvelasquez.prueba;

import com.fvelasquez.prueba.application.services.ProductService;
import com.fvelasquez.prueba.domain.model.Product;
import com.fvelasquez.prueba.domain.port.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService service;

    @Test
    public void testGetAllProducts() {
        Flux<Product> products = Flux.just(new Product("Product 1",
                10.0 ,
                "Vehiculo", 2.0), new Product("Product 2", 20.0 , "Consumo", 4.0));
        when(repository.findAll()).thenReturn(products);

        StepVerifier.create(service.getAllProducts())
                .expectNextCount(2)
                .verifyComplete();
    }

}
