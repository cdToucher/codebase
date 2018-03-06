package me.codebase.designPattern.singleton;

/**
 * Created by chendong on 2017/1/23.
 *
 * 饿加载 内部类 单例
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton(){

    }

    private static class InnerClass {
        private static final StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance(){
        return InnerClass.instance;
    }

}
