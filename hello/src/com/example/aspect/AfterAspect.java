package com.example.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterAspect {

    // 即使目标方法因为异常终止，但是 After 增强处理依然被正常织入， 相当于 finally 代码块
    @After("execution(* com.example.service.*.*(..))")
    public void release(){
        System.out.println("...模拟方法结束后释放资源...");
    }
}
