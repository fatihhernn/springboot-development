package com.fatihhernn.springaop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Before("execution(* com.fatihhernn.springaop.service.*.sendMessage(..))")
    public void beforeFromSendMessage(JoinPoint joinPoint){
        System.out.println("sendMessage metodundan önce parametre yakalandı "+joinPoint.getArgs()[0]);
        System.out.println("Metot imzası :  "+joinPoint.getSignature());
    }

    @After("execution(* com.fatihhernn.springaop.service.*.*(..))")
    public void afterFromSendMessage(JoinPoint joinPoint){
        System.out.println("sendMessage metodundan sonra parametre yakalandı "+joinPoint.getArgs()[0]);
        System.out.println("Metot imzası :  "+joinPoint.getSignature());
    }

}
