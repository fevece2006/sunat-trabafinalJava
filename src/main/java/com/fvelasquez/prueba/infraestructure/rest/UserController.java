package com.fvelasquez.prueba.infraestructure.rest;

import com.fvelasquez.prueba.application.services.UserService;
import com.fvelasquez.prueba.domain.model.User;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public Flux<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public Mono<User> getUserById(@PathVariable String id) {
        return service.getUserById(id);
    }

    @PostMapping
    public Mono<User> createUser(@RequestBody User user) {

        return service.createUser(user);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUserById(@PathVariable String id) {
        return service.deleteUserById(id);
    }

    @PutMapping("/{id}")
    public Mono<User> updateUserById(@PathVariable String id, @RequestBody User user) {
        return service.updateUserById(id, user);
    }

    @GetMapping("/login")
    public Mono<User> loginUser(@RequestParam String email, @RequestParam String password) {
        return service.getUserByEmailAndPassword(email, password);
    }

    @GetMapping("/loginH")
    public Mono<User> loginH(@RequestHeader String email, @RequestHeader String password) {
        return service.getUserByEmailAndPassword(email, password);
    }

    @PostMapping("/login")
    public Mono<User> loginUser(@RequestBody User loginRequest) {
        return service.getUserByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
    }

}
