package com.example.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

// 实现 ApplicationContextAware 接口中的 setApplicationContext() 方法， 让Bean能够访问Spring容器
public class Japanese implements ApplicationContextAware, BeanFactoryAware {

    private ApplicationContext context;
    private BeanFactory factory;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public ApplicationContext getContext() {
        return context;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.factory = beanFactory;
    }

    public BeanFactory getFactory() {
        return factory;
    }
}
