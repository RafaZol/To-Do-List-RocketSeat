package br.com.rafaelzolet.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITodolistUserRepository extends JpaRepository<TodolistUserModel, UUID>{

    TodolistUserModel findByUserName(String userName); // select

}
