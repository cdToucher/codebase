package me.codebase.designPattern.singleton;

/**
 * Created by chendong on 2017/1/23.
 *
 * 饿加载 内部类 单例
 */
public class InnerClassSingleton {

    private static InnerClass instance = new InnerClass();

    private static class InnerClass {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;
    }

    public static InnerClass getInstance(){
        return instance;
    }

}
