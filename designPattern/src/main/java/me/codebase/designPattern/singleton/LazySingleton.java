package me.codebase.designPattern.singleton;

/**
 * Created by chendong on 2017/1/23.
 * <p>
 * 懒加载 线程安全 单例
 */
public class LazySingleton {

    private LazySingleton() {

    }

    private static LazySingleton instance;

    public static synchronized LazySingleton getInstance() { // synchronized 关键字 用于线程安全 方法
        if (instance == null)
            instance = new LazySingleton();
        return instance;
    }
}
