package br.com.rafaelzolet.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class TodolistUserController {

    @Autowired // gerencia ciclo de vida
    private ITodolistUserRepository repository;
    
    //parametro vem dentro do body
    @PostMapping("/")
    public ResponseEntity create(@RequestBody TodolistUserModel userModel){
        var user = this.repository.findByUserName(userModel.getUserName());

        if(user != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario já cadastrado");
        }
        var userCreated = this.repository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
}
