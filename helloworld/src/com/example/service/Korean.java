package com.example.service;

import org.springframework.beans.factory.InitializingBean;

public class Korean implements Person, InitializingBean {
    private Axe axe;
    private String name;
    @Override
    public void setAxe(Axe axe) {
        System.out.println("正在调用 setAxe");
        this.axe = axe;
    }

    @Override
    public Axe getAxe() {
        return axe;
    }

    @Override
    public void setName(String name) {
        System.out.println("正在调用 setName");
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

    // 所有属性设置完成后，会自动执行 afterPropertiesSet 方法
    // afterPropertiesSet方法，和 init方法 作用完全一样，都是用来指定初始化方法，因此不用同时使用
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("正在执行 InitializingBean 接口中的 afterPropertiesSet 方法");
    }

    public Korean(){
        System.out.println("Spring 容器实例化 Korean");
    }

    public void init(){
        System.out.println("正在执行初始化方法 init");
    }
}
