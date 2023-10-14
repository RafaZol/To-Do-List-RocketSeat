package br.com.rafaelzolet.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController 
@RequestMapping("/user") 
public class TodolistUserController {

    @Autowired // gerencia ciclo de vida
    private ITodolistUserRepository repository;

    @PostMapping("/")
    public TodolistUserModel create(@RequestBody TodolistUserModel userModel){ 
       
        var userCreated = this.repository.save(userModel);
        return userCreated; 
    }
}
