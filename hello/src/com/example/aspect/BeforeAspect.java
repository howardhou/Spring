package com.example.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeAspect {

    // 匹配 com.example.service 包下所有类的所有方法 作为切入点
    @Before("execution(* com.example.service.*.*(..))")
    public void authority(){
        System.out.println("...模拟权限检查...");
    }
}
