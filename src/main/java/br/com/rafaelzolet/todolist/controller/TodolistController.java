package br.com.rafaelzolet.todolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inicio")
public class TodolistController{


    /* Metodos de Acesso Http
     * GET - Buscar informações
     * POST - Adicionar informações
     * Put - alterar uma informação
     * Delete - Remover informação
     * Patch - Alterar somente uma parte da informação
     */
    @GetMapping("")
    public String firstMessage(){
        return "Funcionou";
    }
}