package com.example.service;

import org.springframework.beans.factory.DisposableBean;

public class French implements Person, DisposableBean {
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

    // 销毁完成之前，先调用 destroy 方法，再调用 close 方法
    @Override
    public void destroy() throws Exception {
        System.out.println("正在执行 DisposableBean 接口中的 destroy 方法");
    }

    public void close(){
        System.out.println("正在执行 close 方法");
    }

    public French(){
        System.out.println("Spring 容器实例化 French");
    }
}
