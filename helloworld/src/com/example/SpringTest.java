package com.example;

import com.example.event.EmailEvent;
import com.example.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;

public class SpringTest {
    public static void main(String[] args){
        // 创建 Spring 容器 ApplicationContext
        // ApplicationContext 是Spring的核心， Spring中绝大部分功能是通过该容器实现的
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        System.out.println("实例化ApplicationContext： " + context);

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

        // 复合属性
        Chinese chinese3 = context.getBean("chinese3", Chinese.class);
        System.out.println(chinese3.getAxe().getName());

        // 使用 Java 类进行配置管理
        Chinese chinese4 = context.getBean("chinese4", Chinese.class);
        System.out.println("姓名： " + chinese4.getName() + " 斧头： " +chinese4.getAxe());

        // 使用静态工厂创建Bean, Bean 由静态工厂负责创建，静态工厂(BeingFactory)由Spring容器负责管理
        Being b1 = context.getBean("dog", Being.class);
        b1.testBeing();
        Being b2 = context.getBean("cat", Being.class);
        b2.testBeing();

        // 使用实例工厂创建Bean, Bean 由实例工厂负责创建，实例工厂(PersonFactory)由Spring容器负责创建和管理
        Person p1 = context.getBean("chinese5", Person.class);
        System.out.println(p1.sayHello("张三") + " " + p1.sayGoodBye("张三"));
        Person p2 = context.getBean("american", Person.class);
        System.out.println(p2.sayHello("Jackee") + " " + p2.sayGoodBye("Jackee"));

        // 使用工作Bean：Spring 容器通过getBean方法获取工厂Bean时，容器不会返回FactoryBean实例，而是返回该 FactoryBean 的产品
        Person p3 = context.getBean("chinese6", Person.class);
        System.out.println(p3.sayHello("Marry") + " " + p3.sayGoodBye("Marry"));
        Person p4 = context.getBean("chinese6", Person.class);
        System.out.println(p3 == p4);
        // 要获取 FactoryBean 本身时， 需在 FactoryBean ID 前面加 &
        System.out.println("FactoryBean 本身: "+ context.getBean("&chinese6"));

        // 获取Bean本身的ID： 需要Bean实现BeanNameAware中的setBeanName方法，该方法有Spring容器调用
        English english = context.getBean("english", English.class);
        english.info();

        // 让Bean能够访问Spring容器: 通过实现 ApplicationContextAware 接口中的 setApplicationContext() 方法, 该方法由Spring容器调用
        Japanese japanese = context.getBean("japanese", Japanese.class);
        System.out.println("japanese.getFactory() ："+ japanese.getFactory());
        System.out.println("japanese.getContext() ："+ japanese.getContext());
        System.out.println("context == japanese.getContext() : " + (context == japanese.getContext()));

        Person person2 = context.getBean("french", Person.class);
        person2.useAxe();
        // 为Spring容器注册一个关闭的钩子，保证关闭Spring容器之前调用实例的析构函数
        ((ClassPathXmlApplicationContext) context).registerShutdownHook();
    }
}
