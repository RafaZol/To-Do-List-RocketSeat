package br.com.rafaelzolet.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class TodolistUserController {
    
    //parametro vem dentro do body
    @PostMapping("/")
    public void create(@RequestBody TodolistUserModel userModel){
        System.out.println(userModel.getName());
    }
}
