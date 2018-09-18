package com.example;

import com.example.event.EmailEvent;
import com.example.service.Chinese;
import com.example.service.Person;
import com.example.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;

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

        // P537 使用 设值注入
        Person person = context.getBean("chinese", Person.class);
        person.useAxe();

        String[] a = {"Howard"};
        String hello = context.getMessage("hello", a, Locale.getDefault());
        Object[] b = {new Date()};

        String now = context.getMessage("now", b, Locale.getDefault());
        System.out.println(hello);
        System.out.println(now);

        // 主动触发容器事件
        EmailEvent emailEvent = new EmailEvent("springTest", "houdd321@hotmail.com", "this is a test");
        context.publishEvent(emailEvent);

        // 判断两次请求 Bean 实例是否相等 - singleton 作用域
        System.out.println(context.getBean("personService") == context.getBean("personService"));
        // 判断两次请求 Bean 实例是否相等 - prototype 作用域
        System.out.println(context.getBean("personService2") == context.getBean("personService2"));

        Chinese achinese = context.getBean("achinese", Chinese.class);
        System.out.println("姓名：" + achinese.getName() + " 年龄：" + achinese.getAge() + " 身高：" + achinese.getHeight());

        // 注入集合值
        context.getBean("chinese2", Chinese.class).testCollection();
    }
}
