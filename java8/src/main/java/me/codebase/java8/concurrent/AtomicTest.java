package me.codebase.java8.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicTest {


    private static final ExecutorService service = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {

        test4AtomicBoolean();

    }

    private static void test4AtomicBoolean() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        service.submit(() -> {
           atomicBoolean.getAndSet(false);
        });
    }

    private static void test4AtomicBoolean() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        service.submit(() -> {
            atomicBoolean.getAndSet(false);
        });
    }
}
