package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

// 懒加载，在初始化 Spring容器时，不会初始化该Bean，
// 当用到时，再初始化
@Lazy(true)
@Component
public class English implements Person {

    private Axe axe;
    private Being being;

    // 使用 @Autowired 进行自动装配
    // 默认情况下，Spring 采用的是 byType 自动装配策略：该策略会自动搜索Spring容器中类型为Axe的Bean的实例，并将该Bean的实例作为 setter 的参数传人
    // 如果采用的是 byName 自动装配策略，该策略会自动搜索Spring容器中ID为axe的Bean的实例, 并将该Bean的实例作为 setter 的参数传人
    // 这里采用的是 byName 自动装配策略
    @Autowired
    public void setAxe(Axe axe) {
        this.axe = axe;
    }

    public Axe getAxe() {
        return axe;
    }

    // 这里采用的是 byType 自动装配策略
    @Autowired
    public void setBeing(Being being) {
        this.being = being;
    }

    public Being getBeing() {
        return being;
    }

    @Override
    public void useAxe() {
        System.out.println("English: "+axe.chop());
    }

    public void feedBeing(){
        System.out.println("English: 喂食物给： " + being);
    }
}
