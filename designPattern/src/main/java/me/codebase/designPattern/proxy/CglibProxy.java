package me.codebase.designPattern.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by chendong on 2017/2/21.
 * <p>
 * 利用字节码技术动态生成class文件 实现动态代理
 *
 * 值得注意的是字节码技术 对final 类型的方法无法创建出
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz){
        //设置需要创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //通过字节码技术动态创建子类实例
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("前置代理");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("后置代理");
        return result;
    }

    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        RealSubject subject = (RealSubject) proxy.getProxy(RealSubject.class);

        subject.doSomething(); //能被代理

        subject.doSomeOther(); //只能调用不能被代理
    }
}
