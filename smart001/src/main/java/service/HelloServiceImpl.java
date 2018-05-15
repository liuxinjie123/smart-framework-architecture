package service;

import api.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public void say(String text) {
        System.out.println(" Hello " + text);
    }
}
