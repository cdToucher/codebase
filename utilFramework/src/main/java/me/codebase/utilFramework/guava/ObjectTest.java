package me.codebase.utilFramework.guava;


import com.google.common.base.Objects;

/**
 * Created by chendong on 2017/2/9.
 * <p>
 * over write Object base methods
 */
public class ObjectTest {

    /*
     　1. 自反性reflexive：任何非空引用x，x.equals(x)返回为true；
　　　　2. 对称性symmetric：任何非空引用x和y，x.equals(y)返回true当且仅当y.equals(x)返回true；
　　　　3. 传递性transitive：任何非空引用x和y，如果x.equals(y)返回true，并且y.equals(z)返回true，那么x.equals(z)返回true；
　　　　4. 一致性consistent：两个非空引用x和y，x.equals(y)的多次调用应该保持一致的结果，（前提条件是在多次比较之间没有修改x和y用于比较的相关信息）；
　　　　5. 对于所有非null的值x， x.equals(null)都要返回false。 (如果你要用null.equals(x)也可以，会报NullPointerException)。
     */

    static class Person {

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


    public static void main(String[] args) {
        System.out.println(Objects.equal("a", "a"));
        System.out.println(Objects.equal(null, "a"));
        System.out.println(Objects.equal("a", null));
        System.out.println(Objects.equal(null, null));

        System.out.println(java.util.Objects.equals("a", "a"));
        System.out.println(java.util.Objects.equals(null, "a"));
        System.out.println(java.util.Objects.equals("a", null));
        System.out.println(java.util.Objects.equals(null, null));

//        System.err.println(Objects.equal(new User(), new User()));
//
//        System.err.println(Objects.hashCode(new User()));
//        System.err.println(Objects.hashCode(new User(), new User()));
    }


}
