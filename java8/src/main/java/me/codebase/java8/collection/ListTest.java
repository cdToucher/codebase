package me.codebase.java8.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.stream.IntStream;

/**
 * Created by chendong on 2017/3/13.
 * <p>
 * ArrayList Vector
 */
public class ListTest {

    public static void main(String[] args) {
        ArrayList arrayList =new ArrayList(); //数组
        Vector<String> vector = new Vector<>(2); // 基本线程安全
        LinkedList linkedList = new LinkedList();// 双向链表
        IntStream.range(1, 10).forEach(System.out::println);
    }
}
