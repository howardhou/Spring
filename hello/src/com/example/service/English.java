package com.example.service;

import org.springframework.context.annotation.Lazy;

// 懒加载，在初始化 Spring容器时，不会初始化该Bean，
// 当用到时，再初始化
@Lazy(true)
public class English implements Person {
    @Override
    public void useAxe() {
        System.out.println("未实现");
    }


}
