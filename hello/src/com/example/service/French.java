package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
public class French implements Person {
    // 使用 @Autowired 标注 Field , Spring 采用 byType 或 byName 自动装配策略
    @Autowired
    private Axe axe;
    @Autowired
    private Dog dog;

    @Autowired
    private Axe[] axes;
    // 使用 @Autowired 标注多个参数的 普通方法
//    @Autowired
//    public void prepare(Axe axe, Dog dog){
//        this.axe = axe;
//        this.dog = dog;
//    }

    // 使用 @Autowired 标注多参数的 构造函数
//    @Autowired
//    public French(Axe axe, Dog dog){
//        this.axe = axe;
//        this.dog = dog;
//    }

    @Override
    public void useAxe() {
        System.out.println("French: "+axe.chop());
        System.out.println("French: " + dog);
        System.out.println("French: axes length - " + axes.length);
    }
}
