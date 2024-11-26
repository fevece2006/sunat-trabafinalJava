package com.fvelasquez.prueba.domain.port;

import com.fvelasquez.prueba.domain.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User, String>{
}
