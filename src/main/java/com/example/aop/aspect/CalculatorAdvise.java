package com.example.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class CalculatorAdvise {

    @Around("execution(* com.example.aop.Calculator.sum(..))")
    public Object aroundSum(ProceedingJoinPoint pjt) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start();

        Object result = pjt.proceed();

        sw.stop();
        System.out.println("sw.getTotalTimeMillis() = " + sw.getTotalTimeMillis());

        return result;
    }
}
