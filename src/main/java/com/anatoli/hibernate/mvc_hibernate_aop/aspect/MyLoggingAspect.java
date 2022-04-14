package com.anatoli.hibernate.mvc_hibernate_aop.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * показывает в консоли изменения по работникам: добавление, удаление и тд
 */
@Component
@Aspect
public class MyLoggingAspect {
    @Around("execution(* com.anatoli.hibernate.mvc_hibernate_aop.dao.*.*(..))")  //на какие методы будет распространяться:
    // первая звездочка с любым аксэсмодэфаером, с любым ретерн тайпом, методам какого класса com...dao, на все классы пакета(вторая звездочка),
    //на все методы класса, для методов с любым количество параметров (..)
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName= methodSignature.getName();

        System.out.println("Begin of " + methodName);

        Object targetMethodResult = proceedingJoinPoint.proceed();

        System.out.println("End of " + methodName);
        return targetMethodResult;
    }
}
