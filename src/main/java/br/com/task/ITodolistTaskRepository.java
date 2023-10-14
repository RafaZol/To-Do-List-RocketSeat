package br.com.task;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITodolistTaskRepository extends JpaRepository<TodolistTaskModel, UUID> {
    
}
