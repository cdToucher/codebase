package me.codebase.java8.tupleCompare;

import org.javatuples.KeyValue;
import org.javatuples.Pair;

/**
 * roll
 * Java tuple
 * 2-10
 * it could be immutable tuple (1,2) in scala which collection tobe a Map
 *
 * nice try
 */
public class TestJavaTuple {

    public static void main(String[] args) {
        KeyValue<String, String> keyValue = KeyValue.with("1", "1");

        System.out.println(keyValue.getKey());
        keyValue.setKey("2"); // old keyValue will not change
        System.out.println(keyValue.getKey());

        Integer[] arr = {1,23};
        Pair<Integer,Integer> pair = Pair.fromArray(arr);


    }
}
