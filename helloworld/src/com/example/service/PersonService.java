package com.example.service;

// PersonService 并不是标准的 JavaBean， 但是Spring 仍然可以管理， Spring可以管理任意 POJO
public class PersonService {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void info(){
        System.out.println("姓名：" + name);
    }
}
