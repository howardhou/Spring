package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SpringTest {
    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        // 使用 @Component 标注一个普通的 Spring Bean 类
        System.out.println("-----------" + Arrays.toString(context.getBeanDefinitionNames()));
    }
}
