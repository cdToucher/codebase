package me.codebase.java8.bean;


/**
 * Created by chendong on 2017/1/23.
 * <p>
 * test bean
 */
public class User {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;

    private String sex;

    private int age;
}
