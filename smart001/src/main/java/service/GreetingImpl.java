package service;

import api.Greeting;

public class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        before();
        System.out.println(" Hello " + name);
        after();
//        throw new RuntimeException("TEST");
    }

    private void before() {
        System.out.println(" Before ");
    }

    private void after() {
        System.out.println(" After ");
    }
}
