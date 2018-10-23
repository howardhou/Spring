package com.example.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CustomPointcuts {

    @Pointcut("execution(* com.example.service.*.*(..))")
    public void servicePointcut(){

    }
}
