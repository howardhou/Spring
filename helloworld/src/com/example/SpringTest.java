package com.example;

import com.example.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    public static void main(String[] args){
        // 创建 Spring 容器 ApplicationContext
        // ApplicationContext 是Spring的核心， Spring中绝大部分功能是通过该容器实现的
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        System.out.println(context);

        // Spring容器（ApplicationContext） 可以根据配置文件信息（spring-config.xml），创建PersonService的实例，并为实例设置属性值
        // 这种由容器对象为对象设置属性值的方式称为控制反转


        PersonService p = context.getBean("personService", PersonService.class);
        p.info();
    }
}
