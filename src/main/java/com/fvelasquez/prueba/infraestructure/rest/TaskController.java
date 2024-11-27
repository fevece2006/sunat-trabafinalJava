package com.fvelasquez.prueba.infraestructure.rest;


import com.fvelasquez.prueba.application.services.TaskService;
import com.fvelasquez.prueba.domain.model.Task;
import com.fvelasquez.prueba.infraestructure.security.JwtUtil;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service, JwtUtil jwtUtil) {
        this.service = service;

    }

    @GetMapping
    public Flux<Task> getAllTasks(@RequestHeader("Authorization") String authorization) {
        JwtUtil.validateToken(authorization);
        return service.getAllTasks();
    }

    @GetMapping("/{id}")
    public Mono<Task> getTaskById(@RequestHeader("Authorization") String authorization, @PathVariable String id) {
        JwtUtil.validateToken(authorization);
        return service.getTaskById(id);
    }

    @PostMapping
    public Mono<Task> createTask(@RequestHeader("Authorization") String authorization, @RequestBody Task task) {
        JwtUtil.validateToken(authorization);
        return service.createTask(task);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteTaskById(@RequestHeader("Authorization") String authorization, @PathVariable String id) {
        JwtUtil.validateToken(authorization);
        return service.deleteTaskById(id);
    }

    @PutMapping("/{id}")
    public Mono<Task> updateTaskById(@RequestHeader("Authorization") String authorization, @PathVariable String id, @RequestBody Task task) {
        JwtUtil.validateToken(authorization);
        return service.updateTaskById(id, task);
    }

    @PatchMapping("/{id}")
    public Mono<Task> updateStateTaskById(@RequestHeader("Authorization") String authorization, @PathVariable String id, @RequestBody Task task) {
        JwtUtil.validateToken(authorization);
        return service.updateStateTaskById(id, task);
    }

}
