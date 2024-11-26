package com.fvelasquez.prueba.domain.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String name;
    private Double price;
    private String clase;
    private Double descuento;


    public Product(String s, double v, String c, double d) {

    }
}
