package com.example.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterReturningAspect {

    // 匹配 com.example.service 包下所有类的所有方法 作为切入点
    // 目标方法返回值的名称
    // 只能在目标执行之后织入增强，无法改变目标方法的返回值
    @AfterReturning(returning = "rvt", pointcut = "execution(* com.example.service.*.*(..))")
    public void log(Object rvt){
        System.out.println("...获取目标方法的返回值: " + rvt);
    }
}
