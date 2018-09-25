package com.example.service;

public abstract class German implements Person {
    private Axe axe;
    private String name;
    @Override
    public void setAxe(Axe axe) {
        System.out.println("正在调用 setAxe");
        this.axe = axe;
    }

    // 定义抽象方法，该方法由Spring容器复制实现
    @Override
    public abstract Axe getAxe();

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void useAxe() {
        System.out.println(axe.chop());
    }

    @Override
    public String sayHello(String name) {
        return "你好啊，" + name;
    }

    @Override
    public String sayGoodBye(String name) {
        return "下次见，"+ name;
    }

    public German(){

    }
}
