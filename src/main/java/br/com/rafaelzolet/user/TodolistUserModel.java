package br.com.rafaelzolet.user;

public class TodolistUserModel {
    
    private String userName;
    private String name;
    private String password;

    public String getUserName(){
        return this.userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPassWord(){
        return this.password;
    }
    public void setPassWord(String password){
        this.password = password;
    }
}
