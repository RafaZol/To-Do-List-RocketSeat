package br.com.rafaelzolet.user;

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
    
    @Column(unique = true)
    private String userName;
    private String name;
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;


}
