package com.example;

import com.example.service.Chinese;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SpringTest {
    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        // 使用 @Component 标注一个普通的 Spring Bean 类
        System.out.println("-----------" + Arrays.toString(context.getBeanDefinitionNames()));

        // 使用 @Resource 配置依赖，将 steelAxe 注入到 setter 方法
        context.getBean("chinese", Chinese.class).useAxe();
    }
}
