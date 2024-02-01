package com.todoapp.TodoApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todoapp.TodoApp.model.TodoItem;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    // TodoItem saveAll(TodoItem updatedTodo);
}
