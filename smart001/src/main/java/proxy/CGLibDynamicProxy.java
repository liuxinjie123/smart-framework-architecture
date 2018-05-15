package proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibDynamicProxy implements MethodInterceptor {
    private static volatile CGLibDynamicProxy instance = null;

    public CGLibDynamicProxy() {}

    public static CGLibDynamicProxy getInstance() {
        synchronized (CGLibDynamicProxy.class) {
            if (instance == null) {
                instance = new CGLibDynamicProxy();
            }
        }
        return instance;
    }

    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, objects);
        after();
        return result;
    }

    private void before() {
        System.out.println(" Before ");
    }

    private void after() {
        System.out.println(" After ");
    }
}
