package com.example.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeAspect {

    // 匹配 com.example.service 包下所有类的所有方法 作为切入点
    // 只能在目标执行之前织入增强，无法阻止目标方法的执行
    @Before("execution(* com.example.service.*.*(..))")
    public void authority(){
//        System.out.println("...模拟权限检查...");
    }
}
