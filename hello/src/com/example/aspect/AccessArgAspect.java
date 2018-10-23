package com.example.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.util.Date;

@Aspect
public class AccessArgAspect {

    // args(food, time) : 保证切入点只匹配第一个参数是String，第二个参数是Date的方法
    @AfterReturning(pointcut = "execution(* com.example.service.*.*(..)) && args(food, time)", returning = "retVal")
    public void access(Date time, String food, Object retVal){
        System.out.println("目标方法中String参数为：" + food);
        System.out.println("目标方法中Date 参数为：" + time);
    }
}
