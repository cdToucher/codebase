package me.codebase.java8.thread.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by chendong on 2017/10/23.
 */
public class StateControl {

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

}
