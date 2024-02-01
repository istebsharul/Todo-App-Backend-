package com.todoapp.TodoApp.controller;

import java.util.List;

import com.todoapp.TodoApp.Repository.TodoItemRepository;
import com.todoapp.TodoApp.model.TodoItem;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todos")
public class todoRestApi {

    private final TodoItemRepository todoItemRepository;

    public todoRestApi(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @GetMapping
    public List<TodoItem> getAllTodos() {
        return todoItemRepository.findAll(); // Use repository method to fetch all todos
    }

    @GetMapping("/{todoId}")
    public TodoItem getTodoById(@PathVariable long todoId) {
        return todoItemRepository.findById(todoId).orElse(null); // Use repository method to find todo by ID
    }

    @PostMapping
    public TodoItem addTodo(@RequestBody TodoItem todoItem) {
        if (todoItem != null) {
            return todoItemRepository.save(todoItem);
        } else {
            // Handle the case where todoItem is null
            return null;
        }
    }

    @PutMapping("/{todoId}")
    public TodoItem updateTodo(@PathVariable long todoId, @RequestBody TodoItem updatedTodo) {
        if (todoItemRepository.existsById(todoId)) {
            updatedTodo.setTodoId(todoId);
            return todoItemRepository.save(updatedTodo); // Use repository method to update todo
        }
        return null;
    }

    @DeleteMapping("/{todoId}")
    public void deleteTodo(@PathVariable long todoId) {
        todoItemRepository.deleteById(todoId);
    }
}
