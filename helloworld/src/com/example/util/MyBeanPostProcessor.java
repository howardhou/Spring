package com.example.util;

import com.example.service.Chinese;
import com.example.service.English;
import com.example.service.French;
import com.example.service.Korean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

// 使用 Bean的后处理器
public class MyBeanPostProcessor implements BeanPostProcessor {
    // 对容器中的Bean实例进行后处理
    // bean 需要进行后处理的原Bean实例
    // beanName 实例的名称
    // @return 返回后处理完成后的 Bean
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Bean 后处理器 在初始化之前对" + beanName + "进行增强处理, bean 是：" + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Bean 后处理器 在初始化之后对" + beanName + "进行增强处理, bean 是：" + bean);

        if (bean instanceof Korean){
            Korean korean = (Korean) bean;
            korean.setName("Spring MVC");
        }

        return bean;
    }
}
