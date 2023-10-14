package br.com.rafaelzolet.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;


@RestController 
@RequestMapping("/user") 
public class TodolistUserController {

    @Autowired // gerencia ciclo de vida
    private ITodolistUserRepository repository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody TodolistUserModel userModel){ 
        var user = this.repository.findByUserName(userModel.getUserName());
       
        if(user != null){         
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já cadastrado");
        }

        var passwordHashed = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());

        userModel.setPassword(passwordHashed);

        var userCreated = this.repository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated); 
    }
}
