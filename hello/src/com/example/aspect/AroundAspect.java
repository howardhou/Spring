package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AroundAspect {

    // Around 增强处理可以取得目标方法的最大控制权，可以控制目标方法的执行，改变目标方法的参数，改变目标方法的返回值
    //@Around("execution(* com.example.service.Chinese.*(..))")
    public Object aroundProcess(ProceedingJoinPoint jp) throws Throwable {

        System.out.println("...执行目标方法之前， 开始事务...");
        Object rvt = jp.proceed();

        System.out.println("...执行目标方法之后， 结束事务...");
        return rvt + " 新增的内容";
    }
}
