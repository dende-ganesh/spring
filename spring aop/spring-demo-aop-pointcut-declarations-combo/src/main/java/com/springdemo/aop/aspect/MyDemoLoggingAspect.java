package com.springdemo.aop.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

@Pointcut("execution(* com.springdemo.aop.dao.* .*(..))")
public void forDAOPackage(){


}
@Pointcut("execution(* com.springdemo.aop.dao.*.get*())")
public void beforeGetterAdvice(){

}
@Pointcut("execution(* com.springdemo.aop.dao.*.set*(*))")
public void beforeSetterAdvice(){

}
@Pointcut("forDAOPackage()&&!(beforeGetterAdvice()|| beforeSetterAdvice())")
public void noGetterSetterAdvice(){}
@Before("noGetterSetterAdvice()")
public void beforeAddAccountAdvice() {
    System.out.println("==============>Executing @Before Advice on Account");
}
@Before("forDAOPackage()")
public void performApiAnalytics(){
        System.out.println("===========>Performing API Analytics");
}


}
