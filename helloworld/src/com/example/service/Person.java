package com.example.service;

public interface Person {
    public void setAxe(Axe axe);
    public Axe getAxe() ;

    public void setName(String name) ;
    public String getName() ;

    public void useAxe();

    public String sayHello(String name);
    public String sayGoodBye(String name);
}
