package com.example.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class FourAspect {

    @Around("execution(* com.example.service.*.*(..))")
    public Object aroundProcess(ProceedingJoinPoint jp) throws Throwable {

        System.out.println("Around 增强：修改目标方法的参数和返回值 - 开始");

        // 访问目标方法的参数:  返回执行目标方法时的参数
        Object[] args = jp.getArgs();

        //当执行目标方法的参数存在，并且第一个参数是字符串
        if (args != null && args.length > 0 && args[0].getClass() == String.class){
            args[0] = " 被改变的参数";
        }

        Object rvt = jp.proceed(args);

        System.out.println("Around 增强：修改目标方法的参数和返回值 - 结束");

        if (rvt != null && rvt.getClass() == String.class) {
            return rvt + " 新增的内容";
        }
        else {
            return rvt;
        }
    }

    @Before("execution(* com.example.service.*.*(..))")
    public void authority(JoinPoint jp){
        // 访问目标方法的参数:  返回被增强的目标方法的相关信息
        System.out.println("Before 增强： 被织入增强处理的目标方法为： " + jp.getSignature().getName());
        // 访问目标方法的参数:  返回被增强的目标方法的参数
        System.out.println("Before 增强： 目标方法的参数为： " + Arrays.toString(jp.getArgs()));
        // 访问目标方法的参数:  返回被增强的目标对象
        System.out.println("Before 增强： 目标对象为： " + jp.getTarget());
    }

    @AfterReturning(returning = "rvt", pointcut = "execution(* com.example.service.*.*(..))")
    public void log(JoinPoint jp, Object rvt){
        System.out.println("AfterReturning 增强： 被织入增强处理的目标方法为： " + jp.getSignature().getName());
        System.out.println("AfterReturning 增强： 目标方法的参数为： " + Arrays.toString(jp.getArgs()));
        System.out.println("AfterReturning 增强： 目标对象为： " + jp.getTarget());
    }

    @After("execution(* com.example.service.*.*(..))")
    public void release(JoinPoint jp){
        System.out.println("After 增强： 被织入增强处理的目标方法为： " + jp.getSignature().getName());
        System.out.println("After 增强： 目标方法的参数为： " + Arrays.toString(jp.getArgs()));
        System.out.println("After 增强： 目标对象为： " + jp.getTarget());
    }
}
