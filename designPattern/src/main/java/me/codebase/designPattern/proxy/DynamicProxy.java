package me.codebase.designPattern.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by chendong on 2017/2/20.
 * <p>
 * 这里代理模式代表即为 动态代理
 * <p>
 * 代理模式和装饰器模式 之间的区别 可概括为一句话 ：
 * 我们可以用另外一句话来总结这些差别：使用代理模式，代理和真实对象之间的的关系通常在编译时就已经确定了，而装饰者能够在运行时递归地被构造。
 * <p>
 * jdk 自身利用反射实现了需要实现接口的一种动态代理
 */
public class DynamicProxy implements InvocationHandler {

    private Object proxied;

    public DynamicProxy(Object proxied) {
        this.proxied = proxied;
    }

    public Object getDynamicProxy() {
        return Proxy.newProxyInstance(proxied.getClass().getClassLoader(), proxied.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(proxied, args);
        System.out.println("after");
        return result;
    }

    public static void main(String[] args) {
        DynamicProxy proxy = new DynamicProxy(new RealSubject());
        Subject subject = (Subject) proxy.getDynamicProxy();
        subject.doSomething();
    }

}
