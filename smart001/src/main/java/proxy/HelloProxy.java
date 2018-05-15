package proxy;

import api.HelloService;
import service.HelloServiceImpl;

public class HelloProxy implements HelloService {
    private HelloService helloService;

    public HelloProxy() {
        helloService = new HelloServiceImpl();
    }

    @Override
    public void say(String text) {
        before();
        helloService.say(text);
        after();
    }

    private void before() {
        System.out.println(" Before ");
    }

    private void after() {
        System.out.println(" After ");
    }

}
