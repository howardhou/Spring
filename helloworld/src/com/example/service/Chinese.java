package com.example.service;

import java.lang.reflect.Array;
import java.util.*;

public class Chinese implements Person {
    private Axe axe;
    // 姓名
    private String name;
    //年龄
    private int age;
    // 身高
    private double height;
    // 下面是集合属性
    private List<String> schools;
    private Map scores;
    private Map<String, Axe> phaseAxes;
    private Properties health;
    private Set axes;
    private String[] books;

    public void setAxe(Axe axe) {
        this.axe = axe;
    }

    public Axe getAxe() {
        return axe;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    public void setSchools(List<String> schools) {
        this.schools = schools;
    }

    public List<String> getSchools() {
        return schools;
    }

    public void setAxes(Set axes) {
        this.axes = axes;
    }

    public Set getAxes() {
        return axes;
    }

    public void setBooks(String[] books) {
        this.books = books;
    }

    public String[] getBooks() {
        return books;
    }

    public void setHealth(Properties health) {
        this.health = health;
    }

    public Properties getHealth() {
        return health;
    }

    public void setPhaseAxes(Map<String, Axe> phaseAxes) {
        this.phaseAxes = phaseAxes;
    }

    public Map<String, Axe> getPhaseAxes() {
        return phaseAxes;
    }

    public void setScores(Map scores) {
        this.scores = scores;
    }

    public Map getScores() {
        return scores;
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

    public void testCollection(){
        System.out.println(schools);
        System.out.println(scores);
        System.out.println(phaseAxes);
        System.out.println(health);
        System.out.println(axes);
        System.out.println(Arrays.toString(books));

    }
}
