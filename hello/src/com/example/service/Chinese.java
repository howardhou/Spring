package com.example.service;

import org.springframework.stereotype.Component;

import java.util.*;

// 使用 @Component 标注一个普通的 Spring Bean 类
// 未指定 id 时， 会使用默认的 id, 即：chinese
@Component
public class Chinese implements Person {
    private Axe axe;

    public void setAxe(Axe axe) {
        this.axe = axe;
    }

    public Axe getAxe() {
        return axe;
    }

    @Override
    public void useAxe() {
        System.out.println(axe.chop());
    }

}
