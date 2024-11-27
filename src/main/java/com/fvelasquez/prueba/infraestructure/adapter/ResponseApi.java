package com.fvelasquez.prueba.infraestructure.adapter;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseApi<T> {
    private String status;
    private String message;
    private T data;

}
