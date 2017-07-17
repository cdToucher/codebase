package me.codebase.java8;


import me.codebase.java8.bean.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by chendong on 2017/5/15.
 * <p>
 * java reflect test
 */
public class Test {

    public static void main(String[] args) throws Exception {
        reflectTest();
    }

    private static void reflectTest() throws ClassNotFoundException, IllegalAccessException
            , InstantiationException, InvocationTargetException {
        Class obj = Class.forName("me.codebase.beans.User");
        User test = (User) obj.newInstance();
        Field[] fields = obj.getFields();
        System.out.println(Arrays.toString(fields));
        Arrays.stream(fields).forEach(field -> System.out.println(field.getName()));
        Arrays.stream(fields).forEach(Field::getName);

        Field[] declaredFields = obj.getDeclaredFields();
        declaredFields[0].setAccessible(true);
        System.out.println(declaredFields[0].getName());

        Method[] methods = obj.getDeclaredMethods();
        System.out.println(obj.getCanonicalName());
        Annotation[] annotations = obj.getAnnotations();
        System.out.println(Arrays.toString(methods));
        System.out.println(Arrays.toString(annotations));
        for (Method method : methods) {
            if (method.getName().contains("setName")) {
                Object value = method.invoke(test, "test");
                System.out.println(value);
            }
        }
        System.out.println(test.getName());
    }


    private static void assertTest() {
        // java -ea 需要使用-ea 打开断言
        Test.class.getClassLoader().setClassAssertionStatus("me.codebase.api.java8.reflect.Test", true);
        boolean a = false;
        assert true : "true";
        System.out.println(a);
        assert false : "exception";
        System.out.println(a);
    }


}
