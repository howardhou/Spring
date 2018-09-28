package com.example.service;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.*;

// 在初始化Chinese之前， 强制初始化其他Bean
@DependsOn({"axe","steelAxe"})
// 使用 @Component 标注一个普通的 Spring Bean 类
// 未指定 id 时， 会使用默认的 id, 即：chinese
@Component
public class Chinese implements Person {
    // @Resource 也可以直接用在 Field 上
    private Axe axe;

    // 使用 @Resource 配置依赖，将 steelAxe 注入到 setter 方法
    @Resource(name = "steelAxe")
    public void setAxe(Axe axe) {
        this.axe = axe;
    }

    public Axe getAxe() {
        return axe;
    }

    @Override
    public void useAxe() {
        System.out.println("Chinese: " + axe.chop());
    }

    // Spring容器将会在Bean依赖注入完成后（构造完成后）回调该方法
    @PostConstruct
    public void init(){
        System.out.println("Chinese： 正在执行初始化之后的init方法");

    }

    // Spring 容器将会在销毁该Bean之前回调该方法
    @PreDestroy
    public void close(){
        System.out.println("Chinese： 正在执行销毁之前的close方法");
    }
}
