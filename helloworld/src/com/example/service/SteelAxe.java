package com.example.service;

public class SteelAxe implements Axe {
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
        return "钢斧砍柴很快";
    }
}
