package me.codebase.designPattern.singleton;

/**
 * Created by chendong on 2017/1/23.
 *
 * 饿加载 内部类 单例
 */
public class InnerClassSingleton {

    private InnerClassSingleton(){

    }

    private static class InnerClass {
        private static final InnerClassSingleton instance = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance(){
        return InnerClass.instance;
    }

}
