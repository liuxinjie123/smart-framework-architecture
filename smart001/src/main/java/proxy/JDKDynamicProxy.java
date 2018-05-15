package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKDynamicProxy implements InvocationHandler {
    private Object object;

    public JDKDynamicProxy(Object object) {
        this.object = object;
    }

    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                this
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(object, args);
        after();
        return object;
    }

    private void before() {
        System.out.println(" Before ");
    }

    private void after() {
        System.out.println(" After ");
    }
}
