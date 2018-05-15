package com.smart.controller;


import api.Apology;
import api.Greeting;
import org.springframework.aop.framework.ProxyFactory;
import proxy.*;
import service.GreetingImpl;

public class Client {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetingImpl());
        proxyFactory.addAdvice(new GreetingAfterAdvice());
        proxyFactory.addAdvice(new GreetingBeforeAdvice());
        proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());
        proxyFactory.addAdvice(new GreetingAroundAdvice());
        proxyFactory.addAdvice(new GreetingThrowAdvice());
        Greeting greeting = (Greeting) proxyFactory.getProxy();
        greeting.sayHello("Jack");


        System.out.println(" --------------------------- ");

        Apology apology = (Apology) greeting;
        apology.saySorry("Jack");
    }
}
