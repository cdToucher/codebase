package me.codebase.asm.test;

import sun.misc.LRUCache;

/**
 * Created by chendong on 2017/7/14.
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("Hello ASM!");

        LRUCache cache = new LRUCache(2) {
            @Override
            protected Object create(Object o) {
                return null;
            }

            @Override
            protected boolean hasName(Object o, Object o2) {
                return false;
            }
        };
    }
}
