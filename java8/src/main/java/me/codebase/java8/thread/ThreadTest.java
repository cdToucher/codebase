package me.codebase.java8.thread;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by chendong on 2017/3/1.
 * <p>
 * thread test class
 */
public class ThreadTest{

    private static void print(Object object) {
        System.out.println(object);
    }

    public static void main(String[] args) {
    }

    private static void execute2() {
        ExecutorService service = Executors.newFixedThreadPool(1);
        List<Callable<String>> callableList = Lists.newArrayList();
        try {
            String result = service.invokeAny(callableList);
            List<Future<String>> result1 = service.invokeAll(callableList);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void execute1() {
        try {
            Future<String> future = Executors.newSingleThreadExecutor().submit(() -> print("execute1"), "d");
            while (!future.isDone())
                print("tasks haven't done");
            String result = future.get(1, TimeUnit.HOURS); //指定超时时间
            print(result);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
        Callable<callback> callable = Executors.callable(() -> print("execute1"), () -> print("sdsdfs"));
        try {
            callback result = callable.call();
            result.runCallback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void execute() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            executorService.submit(() -> print("sdsdsd")).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private static void scheduleExecute() {
        Runnable task = ThreadTest::run;
//        Runnable task = () -> System.out.println(1);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.schedule(task, 5, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }


    public static void run() {
        Runnable task = () -> print("work");
        Thread thread = new Thread(task);
        print(thread.getId());
        print(thread.getPriority());
        print(thread.getName());
        print(thread.getThreadGroup().getName());
        print(thread.getThreadGroup().toString());
        print(thread.getState().toString());

        print(thread.isAlive());
        print(thread.isDaemon());
        print(thread.isInterrupted());

        thread.start();
        print(thread.isAlive());
    }

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

    @FunctionalInterface
    interface callback {
       void runCallback();
    }
}
