package com.example;

import com.example.service.Axe;
import com.example.service.Chinese;
import com.example.service.Person;
import com.example.service.StoneAxe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 修饰一个 Java 配置类
@Configuration
public class SpringConfig {

    // 修饰一个值
    @Value("孙悟空") String personName;
    // 修饰一个 Bean， 该方法的返回值 定义成容器中的一个 Bean
    @Bean(name = "chinese4")
    public Person person(){
        Chinese p = new Chinese();
        p.setAxe(stoneAxe());
        p.setName(personName);
        return p;
    }

    @Bean(name = "bigAxe")
    public Axe stoneAxe(){
        return new StoneAxe();
    }
}
