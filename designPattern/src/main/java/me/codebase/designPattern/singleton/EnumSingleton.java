package me.codebase.designPattern.singleton;

/**
 * Created by chendong on 2017/1/23.
 *
 * 饿加载 枚举 单例
 */
public enum EnumSingleton {

    INSTANCE("test", 0);

    EnumSingleton(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;

    private int age;

}
