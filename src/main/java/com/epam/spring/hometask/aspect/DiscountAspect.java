package com.epam.spring.hometask.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DiscountAspect {

    @Pointcut("execution(* com.epam.spring.hometask.service.DiscountService.getDiscount(..))")
    private void getDiscount(){}


    @After("getDiscount()")
    private void notifyGetDiscount(JoinPoint joinPoint){
        System.out.println(joinPoint.getTarget().getClass());
    }
}
