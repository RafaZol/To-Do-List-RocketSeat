package br.com.rafaelzolet.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("/task")
public class TodolistTaskController {

    @Autowired
    private ITodolistTaskRepository taskRepository;

    public TodolistTaskModel create(@RequestBody TodolistTaskModel taskModel){
        var task = this.taskRepository.save(taskModel);
        return task;

    }

    
}
