package com.example.service;

public class WoodAxe implements Axe {
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
        return "木头做的斧子，就是摆设";
    }
}
