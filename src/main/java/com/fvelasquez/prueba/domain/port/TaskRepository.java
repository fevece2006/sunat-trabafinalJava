package com.fvelasquez.prueba.domain.port;

import com.fvelasquez.prueba.domain.model.Task;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TaskRepository extends ReactiveCrudRepository<Task, String>{

}
