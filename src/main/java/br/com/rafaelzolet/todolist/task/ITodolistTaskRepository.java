package br.com.rafaelzolet.todolist.task;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ITodolistTaskRepository extends JpaRepository<TodolistTaskModel, UUID> {

    List<TodolistTaskModel> findByIdUser(UUID idUser);
        
}
