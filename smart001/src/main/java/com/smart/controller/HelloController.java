package com.smart.controller;

import api.HelloService;
import proxy.CGLibDynamicProxy;
import proxy.DynamicProxy;
import service.HelloServiceImpl;

import java.lang.reflect.Proxy;

public class HelloController {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        DynamicProxy dynamicProxy = new DynamicProxy(helloService);
        HelloService helloProxy = (HelloService) Proxy.newProxyInstance(
                helloService.getClass().getClassLoader(),
                helloService.getClass().getInterfaces(),
                dynamicProxy
        );

        helloProxy.say("liuxinjie");

        DynamicProxy dynamicProxy1 = new DynamicProxy(helloService);
        HelloService helloProxy1 = dynamicProxy1.getProxy();
        helloProxy1.say("jack");

        CGLibDynamicProxy cgLibDynamicProxy = new CGLibDynamicProxy();
        HelloService helloProxy2 = cgLibDynamicProxy.getProxy(HelloServiceImpl.class);
        helloProxy2.say("xinjie");

        HelloService helloProxy3 = CGLibDynamicProxy.getInstance().getProxy(HelloServiceImpl.class);
        helloProxy3.say("we will get there.");
    }
}
