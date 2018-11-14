package me.codebase.java8.base;

import java.util.stream.Stream;

public class StreamOrder {

    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .filter(i -> {
                    System.out.println("f" + i);
                    return i > 2;
                })
                .sorted()
                .peek(i -> System.out.println("M" + i))
                .forEach(i -> System.out.println("F" + i));
    }

}
