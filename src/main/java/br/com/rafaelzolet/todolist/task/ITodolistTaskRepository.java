package br.com.rafaelzolet.todolist.task;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITodolistTaskRepository extends JpaRepository<TodolistTaskModel, UUID> {
    
}
