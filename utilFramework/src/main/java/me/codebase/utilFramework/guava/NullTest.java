package me.codebase.utilFramework.guava;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by chendong on 2017/2/9.
 * <p>
 * 使用optional 解释null
 * <p>
 * 这里使用jdk 1.8 自带的Optional
 */
public class NullTest {

    private static void print(Object obj) {
        System.out.println(obj);
    }

    public static void main(String[] args) {
        print(com.google.common.base.Optional.of(args).or(new String[0]));
        print(com.google.common.base.Optional.of(args).asSet());
        print(com.google.common.base.Optional.of(args).isPresent());
        print(com.google.common.base.Optional.of(args).orNull());
        print(Optional.of(args).get());
        print(Optional.of(args).map(Arrays::asList));
    }

}
