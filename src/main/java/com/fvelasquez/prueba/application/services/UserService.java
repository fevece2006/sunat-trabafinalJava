package com.fvelasquez.prueba.application.services;

import com.fvelasquez.prueba.domain.model.User;
import com.fvelasquez.prueba.domain.port.UserRepository;
import com.fvelasquez.prueba.infraestructure.adapter.UserNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Flux<User> getAllUsers() {
        return repository.findAll();
    }

    public Mono<User> getUserById(String id) {
        return repository
                .findById(id)
                .switchIfEmpty(Mono.error(new UserNotFoundException("Usuario no encontrado con id " + id)))
                .onErrorResume(throwable -> {
                    // Puedes agregar lógica adicional para manejar diferentes tipos de errores si es necesario
                    if (throwable instanceof UserNotFoundException) {
                        return Mono.error(throwable);
                    }
                    // Retornar un Mono que contiene un objeto de error personalizado para otros tipos de errores
                    return Mono.error(new UserNotFoundException("Error al buscar usuario con id " + id));
                });
    }

    public Mono<User> createUser(User user) {
        return repository.save(user);
    }

    public Mono<Void> deleteUserById(String id) {
        return repository.deleteById(id);
    }

    public Mono<User> updateUserById(String id, User user) {
        return repository.findById(id)
                .flatMap(existingUser -> {
                    existingUser.setUser(user.getUser());
                    existingUser.setEmail(user.getEmail());
                    existingUser.setPassword(user.getPassword());
                    return repository.save(existingUser);
                });
    }


}
