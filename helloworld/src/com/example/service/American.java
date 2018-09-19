package com.example.service;

public class American implements Person {
    private Axe axe;
    private String name;

    @Override
    public void setAxe(Axe axe) {
        this.axe = axe;
    }

    @Override
    public Axe getAxe() {
        return this.axe;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void useAxe() {
        System.out.println(axe.chop());
    }

    @Override
    public String sayHello(String name) {
        return name + ", hello.";
    }

    @Override
    public String sayGoodBye(String name) {
        return name + "Good bye.";
    }
}
