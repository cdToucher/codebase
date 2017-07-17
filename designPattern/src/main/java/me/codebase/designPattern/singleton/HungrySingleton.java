package me.codebase.designPattern.singleton;

/**
 * Created by chendong on 2017/1/23.
 *
 * 饿加载 单例
 */
public class HungrySingleton {

    private HungrySingleton() {

    }

    private static HungrySingleton instance = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return instance;
    }
}
