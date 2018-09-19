package com.example.service;

public class Dog implements Being {
    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public void testBeing() {
        System.out.println(msg + "   狗爱吃骨头");
    }
}
