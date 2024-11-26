package com.fvelasquez.prueba.infraestructure.rest;


import com.fvelasquez.prueba.application.services.TaskService;
import com.fvelasquez.prueba.domain.model.Task;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public Flux<Task> getAllTasks() {
        return service.getAllTasks();
    }

    @GetMapping("/{id}")
    public Mono<Task> getTaskById(@PathVariable String id) {
        return service.getTaskById(id);
    }

    @PostMapping
    public Mono<Task> createTask(@RequestBody Task task) {

        return service.createTask(task);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteTaskById(@PathVariable String id) {
        return service.deleteTaskById(id);
    }

    @PutMapping("/{id}")
    public Mono<Task> updateTaskById(@PathVariable String id, @RequestBody Task task) {
        return service.updateTaskById(id, task);
    }

    @PatchMapping("/{id}")
    public Mono<Task> updateStateTaskById(@PathVariable String id, @RequestBody Task task) {
        return service.updateStateTaskById(id, task);
    }


}
