package com.springdemo.aop;

import com.springdemo.aop.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO=context.getBean("accountDAO",AccountDAO.class);
        boolean tripWire=false;
        List<Account> theAccounts=accountDAO.findAccount(tripWire);
        System.out.println("Main Progaram:After Returning DemoApp");
        System.out.println("--------------------");
        System.out.println(theAccounts);
        context.close();
    }
}
