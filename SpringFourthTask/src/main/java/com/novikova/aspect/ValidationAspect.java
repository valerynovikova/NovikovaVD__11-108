package com.novikova.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    @Pointcut("within(com.novikova.service.ValidationService)")
    public void validationPointcut(){}

    @Around("validationPointcut()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("In Around Aspect");
        int arg = (int) joinPoint.getArgs()[0];
        if(arg < 0)
            throw new RuntimeException("Argument should not be negative");
        else
            joinPoint.proceed();
    }
}
