package me.codebase.algorithm.test;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by chendong on 2017/7/17.
 */
public class Test {


    public static void main(String[] args) {
        System.out.println(new String(Base64.getDecoder().decode("NDc2OTMwMDM4")));
    }

    private static void test() {
        // 线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        // 只能5个线程同时访问
        final Semaphore semp = new Semaphore(3);
        // 模拟20个客户端访问
        for (int index = 0; index < 10; index++) {
            final int NO = index;
            exec.submit(() -> {
                try {
                    // 获取许可
                    semp.acquire();
                    System.out.println("Accessing: " + NO);
                    Thread.sleep((long) (Math.random() * 6000));
                    // 访问完后，释放
                    semp.release();
                    //availablePermits()指的是当前信号灯库中有多少个可以被使用
                    System.out.println("-----------------" + semp.availablePermits());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        // 退出线程池
        exec.shutdown();
    }

    private static void countDownLatchTest() throws InterruptedException {
        int threads = 3;
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        InnerClass innerClass = new InnerClass();
        for (int i = 1; i <= threads; i++) {
            new Thread(() -> {
                for (int j = 0; j < 4; j++) {
                    innerClass.add(String.valueOf(j));
                    innerClass.print();
                }
                innerClass.set("hello world");
                countDownLatch.countDown();
            }, "thread - " + i).start();
        }
        countDownLatch.await();
        System.out.println("finish!");
    }

    private static class InnerClass {
        public void add(String newStr) {
            StringBuilder str = Counter.counter.get();
            Counter.counter.set(str.append(newStr));
        }

        public void print() {
            System.out.printf("Thread name:%s , ThreadLocal hashcode:%s, Instance hashcode:%s, Value:%s\n",
                    Thread.currentThread().getName(),
                    Counter.counter.hashCode(),
                    Counter.counter.get().hashCode(),
                    Counter.counter.get().toString());
        }

        public void set(String words) {
            Counter.counter.set(new StringBuilder(words));
            System.out.printf("Set, Thread name:%s , ThreadLocal hashcode:%s,  Instance hashcode:%s, Value:%s\n",
                    Thread.currentThread().getName(),
                    Counter.counter.hashCode(),
                    Counter.counter.get().hashCode(),
                    Counter.counter.get().toString());
        }
    }

    private static class Counter {
        private static final ThreadLocal<StringBuilder> counter = ThreadLocal.withInitial(StringBuilder::new);
    }

}
