package me.codebase.java8.function;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by chendong on 2017/3/2.
 * <p>
 * java 8 functional interface test
 */
public class FunctionalInterfaceTest {

    public static void print(Object object) {
        System.out.println(object);
    }

    public static void main(String[] args) {
        Function<String, String> function1 = String::trim;
        Supplier<String> supplier1 = String::new;
        Consumer<String> consumer1 = String::toString;
        Comparator<String> comparator =  (a,b)->a.codePointAt(1);
        Predicate<String> predicate1 = s -> s.equals(consumer1);
    }


}
