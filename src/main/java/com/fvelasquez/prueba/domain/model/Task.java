package com.fvelasquez.prueba.domain.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "tasks")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    private String id;
    private String name;
    private Integer category;
    private Date date;
    private Integer priority;
    private Integer state;
}
