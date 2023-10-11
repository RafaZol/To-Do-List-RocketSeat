package br.com.rafaelzolet.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public class TodolistUserRepository  extends JpaRepository<TodolistUserModel, UUID>{

    

}
