package me.codebase.designPattern.singleton;

/**
 * Created by chendong on 2017/1/23.
 * <p>
 * 懒加载 双重锁 单例
 */
public class DoubleCheckSingleton {

    private static volatile DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {

    }

    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null)
                    instance = new DoubleCheckSingleton();
            }
        }
        return instance;
    }
}
