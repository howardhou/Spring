package com.example;

import com.example.service.Chinese;
import com.example.service.English;
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

        // 使用 @Autowired 进行自动装配
        context.getBean("english", English.class).useAxe();

        context.getBean("english", English.class).feedBeing();
    }
}
