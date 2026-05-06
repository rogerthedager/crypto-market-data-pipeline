package com.roger.crypto;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {




//    @Before("execution(public * com.example.AOP.Test.*.*.*(..))")
//    public void before(JoinPoint point){
//        System.out.println("before -- function name = " + point.getSignature().getName());// non business logic
//        // System.out.println("before -- " + Arrays.toString(point.getArgs()));
//    }
//


    @Around("execution(public * com.example.AOP.Test.repository.*.*(..))")
    public Object around(ProceedingJoinPoint point){
        System.out.println("around -- function name = " + point.getSignature().getName());// non business logic
        //System.out.println("around -- " + Arrays.toString(point.getArgs()));

        long k = System.currentTimeMillis();

        Object res ;
        try {
            res = point.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        System.out.println("around -- function takes " + (System.currentTimeMillis()-k) + " ms");

        return res;
    }


//    @After("execution(public * com.example.AOP.Test.*.*.*(..))")
//    public void after(JoinPoint point){
//        System.out.println("after -- function name = " + point.getSignature().getName());
//        //System.out.println("after -- " + Arrays.toString(point.getArgs()));
//
//        long k = System.currentTimeMillis();
//
//
//        System.out.println("around -- function takes " + (System.currentTimeMillis()-k) + " ms");
//
//    }
}
