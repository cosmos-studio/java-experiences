package skills.proxy.m3;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ProxyFactory implements MethodInterceptor {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object proxyObj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("transaction start");
        // Object returnValue = method.invoke(target, args);
        // Object returnValue = proxy.invoke(target,args);
        Object returnValue = proxy.invokeSuper(proxyObj, args);
        System.out.println("transaction stop");
        System.out.println(proxyObj.getClass());
        return returnValue;
    }
}
