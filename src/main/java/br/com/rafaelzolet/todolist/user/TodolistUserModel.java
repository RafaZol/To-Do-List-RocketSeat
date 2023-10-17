package br.com.rafaelzolet.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data // todos getters e setters
@Entity(name = "tb_users")
public class TodolistUserModel {

    @Id //chave primaria
    @GeneratedValue(generator = "UUID")
    private UUID id;
    
    @Column(unique = true, name = "username")
    private String userName;
    private String name;
    private String password;

    @CreationTimestamp
    @Column(name = "createdat")
    private LocalDateTime createdAt;


}
