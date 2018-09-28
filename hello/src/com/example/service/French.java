package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
public class French implements Person {
    private Axe axe;
    private Dog dog;

    // 使用 @Autowired 标注多个参数的 普通方法
//    @Autowired
//    public void prepare(Axe axe, Dog dog){
//        this.axe = axe;
//        this.dog = dog;
//    }

    // 使用 @Autowired 标注多参数的 构造函数
    @Autowired
    public French(Axe axe, Dog dog){
        this.axe = axe;
        this.dog = dog;
    }

    @Override
    public void useAxe() {
        System.out.println("French: "+axe.chop());
        System.out.println("French: " + dog);
    }
}
