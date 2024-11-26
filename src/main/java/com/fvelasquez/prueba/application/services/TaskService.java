package com.fvelasquez.prueba.application.services;

import com.fvelasquez.prueba.domain.model.Task;
import com.fvelasquez.prueba.domain.port.TaskRepository;
import com.fvelasquez.prueba.infraestructure.adapter.TaskNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Flux<Task> getAllTasks() {
        return repository.findAll();
    }

    public Mono<Task> getTaskById(String id) {
        return repository
                .findById(id)
                .switchIfEmpty(Mono.error(new TaskNotFoundException("Tarea no encontrado con id " + id)))
                .onErrorResume(throwable -> {
                    // Puedes agregar lógica adicional para manejar diferentes tipos de errores si es necesario
                    if (throwable instanceof TaskNotFoundException) {
                        return Mono.error(throwable);
                    }
                    // Retornar un Mono que contiene un objeto de error personalizado para otros tipos de errores
                    return Mono.error(new TaskNotFoundException("Error al buscar la tarea con id " + id));
                });
    }

    public Mono<Task> createTask(Task task) {
        return repository.save(task);
    }

    public Mono<Void> deleteTaskById(String id) {
        return repository.deleteById(id);
    }

    public Mono<Task> updateTaskById(String id, Task task) {
        return repository.findById(id)
                .flatMap(existingTask -> {
                    existingTask.setName(task.getName());
                    existingTask.setCategory(task.getCategory());
                    existingTask.setDate(task.getDate());
                    existingTask.setPriority(task.getPriority());
                    existingTask.setState(task.getState());
                    return repository.save(existingTask);
                });
    }

    public Mono<Task> updateStateTaskById(String id, Task task) {
        return repository.findById(id)
                .flatMap(existingTask -> {
                    existingTask.setState(task.getState());
                    return repository.save(existingTask);
                });
    }


}
