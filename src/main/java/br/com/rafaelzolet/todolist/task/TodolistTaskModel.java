package br.com.rafaelzolet.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_task")
public class TodolistTaskModel {
    /*
     * Usuário
     * Descrição
     * Titulo
     * Data de Inicio
     * Data de término
     * Prioridade
     */
     @Id
     @GeneratedValue(generator = "UUID")
     private UUID id;
     private String description;

     @Column(length = 50)
     private String title;
     @Column(name = "startat")
     private LocalDateTime startAt;
     @Column(name = "endat")
     private LocalDateTime endAt;
     private String priority;

     @CreationTimestamp
     @Column(name = "createdat")
     private LocalDateTime createdAt;
     @Column(name = "id_user")
     private UUID idUser;

     public void setTitle(String title) throws Exception{
        if(title.length() > 50){
            throw new Exception("O campo title de conter no maximo 50 caracteres");
        }
        this.title = title;
     }
}
