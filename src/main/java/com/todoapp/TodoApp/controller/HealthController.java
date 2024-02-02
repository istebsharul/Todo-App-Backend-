package com.todoapp.TodoApp.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/dbHealth")
    public ResponseEntity<String> databaseHealthCheck() {
        try (Connection connection = dataSource.getConnection()) {
            return ResponseEntity.ok("Database connection is healthy");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Database connection error: " + e.getMessage());
        }
    }
}