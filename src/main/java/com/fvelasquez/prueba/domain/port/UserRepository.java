package com.fvelasquez.prueba.domain.port;

import com.fvelasquez.prueba.domain.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, String>{

    Mono<User> findByEmailAndPassword(String email, String password);

}
