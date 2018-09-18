package com.example.service;

public class Chinese implements Person {
    private Axe axe;
    // 姓名
    private String name;
    //年龄
    private int age;
    // 身高
    private double height;

    public void setAxe(Axe axe) {
        this.axe = axe;
    }

    public Axe getAxe() {
        return axe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public Chinese(){}

    public Chinese(Axe axe){
        this.axe = axe;
    }

    public Chinese(String name, int age, double height){
        this.name = name;
        this.age = age;
        this.height = height;
    }

    @Override
    public void useAxe() {
        System.out.println(axe.chop());
    }
}
