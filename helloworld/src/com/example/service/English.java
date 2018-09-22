package com.example.service;

import org.springframework.beans.factory.BeanNameAware;

public class English implements BeanNameAware {
    private String beanName;

    // Spring 容器初始化Bean完成之后，回调该方法，获得Bean的ID
    // Bean 的初始化行为包括：回调实现 InitializingBean 接口所实现的afterPropertiesSet()方法、回调Bean配置中init-method属性所指定的方法
    // 其实需要获得Bean id的情况并不常见
    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    public void info(){
        System.out.println("English 实现类" + "， 部署该Bean时指定地id为" + beanName);
    }

}
