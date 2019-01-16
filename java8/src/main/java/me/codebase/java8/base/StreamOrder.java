package me.codebase.java8.base;

import java.util.stream.Stream;

import static java.lang.System.out;

public class StreamOrder {

    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .filter(i -> {
                    out.println("f" + i);
                    return i > 2;
                })
                .sorted()
                .peek(i -> out.println("M" + i))
                .forEach(i -> out.println("F" + i));
    }

}
