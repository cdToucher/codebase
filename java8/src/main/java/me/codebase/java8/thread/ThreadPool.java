package me.codebase.java8.thread;

/**
 * Created by chendong on 2017/3/1.
 */
public class ThreadPool {
    private static ThreadPool ourInstance = new ThreadPool();

    public static ThreadPool getInstance() {
        return ourInstance;
    }

    private ThreadPool() {
    }

    
}
