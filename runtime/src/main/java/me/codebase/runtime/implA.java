package me.codebase.runtime;

import java.util.function.Consumer;

/**
 * Created by chendong on 2018/1/18.
 */
public class implA implements Consumer<Integer> {
    @Override
    public void accept(Integer s) {
        System.out.println(s * 2);
    }
}
