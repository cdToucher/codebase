package me.codebase.designPattern.singleton;

import java.io.Serializable;

/**
 * Created by chendong on 2017/1/23.
 * <p>
 * 如果Singleton实现了java.io.Serializable接口，那么这个类的实例就可能被序列化和复原。
 * 不管怎样，如果你序列化一个单例类的对象，接下来复原多个那个对象，那你就会有多个单例类的实例。
 *
 * 如果单例由不同的类装载器装入，那便有可能存在多个单例类的实例。
 * 假定不是远端存取，例如一些servlet容器对每个servlet使用完全不同的类  装载器，这样的话如果有两个servlet访问一个单例类，它们就都会有各自的实例。
 */
public class SingletonProblem implements Serializable {

    private static final long serialVersionUID = 4492608089887711289L;

    public static SingletonProblem INSTANCE = new SingletonProblem();

    private SingletonProblem() {

    }

    private Object readResolve() {  // 序列化造成的 单例失效 可以通过实现readResolve 来解决
        return INSTANCE;
    }


    /*
    --------------------------------------------------------------------------------------------------------------------
     */

    public static Class<?> getInstance() throws ClassNotFoundException { // 多个classloader 造成的单例失效 则需要同classloader 获取
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null)
            classLoader = SingletonProblem.class.getClassLoader();
        return (classLoader.loadClass(SingletonProblem.class.getName()));
    }

}
