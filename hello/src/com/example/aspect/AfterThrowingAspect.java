package com.example.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterThrowingAspect {

    // AfterThrowing 不能完全处理目标方法的异常，这和 catch不一样, 目标方法依然会crash
    @AfterThrowing(throwing = "ex", pointcut = "execution(* com.example.service.*.*(..))")
    public void doRecoveryActions(Throwable ex){
        System.out.println("目标方法中抛出的异常: " + ex);
    }
}
