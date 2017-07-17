package me.codebase.designPattern.builder;

/**
 * Created by chendong on 2017/2/20.
 */
public class BuilderTest {

    private Pojo instance;

    public static BuilderTest builder() {
        BuilderTest builderTest = new BuilderTest();
        builderTest.instance = new Pojo();
        return builderTest;
    }

    public BuilderTest setName(String name) {
        instance.name = name;
        return this;
    }

    public BuilderTest setAge(int age) {
        instance.age = age;
        return this;
    }

    public BuilderTest setSex(String sex) {
        instance.sex = sex;
        return this;
    }

    public Pojo build() {
        return instance;
    }

    private static class Pojo {

        private String name;

        private int age;

        private String sex;

        @Override
        public String toString() {
            return name + age + sex;
        }
    }

    public static void main(String[] args) {
        System.out.println(BuilderTest.builder().setName("1").setAge(1).setSex("d").build().toString());
    }

}
