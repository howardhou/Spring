package com.example.service;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Being {

    private int age;
    private String name;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
