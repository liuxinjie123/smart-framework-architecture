package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    private Object object;

    public DynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(method);
        Object result = method.invoke(object, args);
        after(method);
        return result;
    }

    private void before(Method method) {
        System.out.println(" Before " + method.getName());
    }

    private void after(Method method) {
        System.out.println(" After " + method.getName());
    }

    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                this
        );
    }
}
