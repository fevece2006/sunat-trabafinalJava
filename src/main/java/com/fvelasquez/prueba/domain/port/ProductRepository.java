package com.fvelasquez.prueba.domain.port;

import com.fvelasquez.prueba.domain.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<Product, String> {

}
