package me.codebase.java8.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by chendong on 2017/10/23.
 * <p>
 * class atomicXX 利用了cpu的特性保证了原子性
 */
public class AtomicObj {

    public static void shutdown(ExecutorService executor, long seconds) {
        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(seconds, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks right now");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }


    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);

        ExecutorService service1 = Executors.newSingleThreadExecutor();
        service1.submit(() -> {
            for (int i = 0; i < 10; i++) {
                atomicInteger.incrementAndGet();
            }
        });

        ExecutorService service2 = Executors.newSingleThreadExecutor();
        service2.submit(() -> {
            for (int i = 0; i < 10; i++) {
                atomicInteger.incrementAndGet();
            }
        });
        shutdown(service1, 5);
        shutdown(service2, 5);

        while (service1.isTerminated() && service2.isTerminated()) {
            System.out.println(atomicInteger.get());
            return;
        }
    }
}
