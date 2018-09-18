package com.example.service;

public class StoneAxe implements Axe{
    private String name;
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String chop() {
        return "石头做的斧子砍柴很慢";
    }
}
