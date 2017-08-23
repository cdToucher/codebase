package me.codebase.java8.base;

import java.util.HashMap;

/**
 * Created by chendong on 2017/8/21.
 */
public class HashMapAnalysis {

/*
     static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
*/

    public static void main(String[] args) {
        HashMap map = new HashMap();
        String a = "1";
        map.put(a, "2");
        HashMap map1 = map;

        HashMap map2 = new HashMap();
        map2.put(a, "2");
        System.out.println(a.hashCode());
        System.out.println("1".hashCode());
        System.out.println(map.hashCode());
        System.out.println(map1.hashCode());
        System.out.println(map2.hashCode());

        System.out.println(8 >> 1);
        System.out.println(Integer.valueOf("11110001",2));
        System.out.println(Byte.valueOf("00000001").intValue());
        System.out.println(6 >>> 1);

    }


}
