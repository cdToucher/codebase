package me.codebase.utilFramework.guava;

import com.google.common.util.concurrent.AbstractIdleService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.Executors;

/**
 * Created by chendong on 2017/7/20.
 */
public class ThreadServiceTest extends AbstractIdleService {

    private AnnotationConfigApplicationContext context;

    public static void main(String[] args) throws Exception {
        ThreadServiceTest test = new ThreadServiceTest();
        test.startAsync().awaitTerminated();
    }

    @Override
    protected void startUp() throws Exception {
        context = new AnnotationConfigApplicationContext();
        context.start();
    }

    @Override
    protected void shutDown() throws Exception {
        context.stop();
        context.destroy();
    }

    public void java8Service() {
        Executors.newSingleThreadExecutor();


    }

    private volatile boolean running;

    public void run() {
        running = true;
        while (running) {
            running = doWork();
            if (Thread.interrupted()) {
                return;
            }
        }
    }

    public boolean doWork() {
        try {
            new AnnotationConfigApplicationContext();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void stopRunning() {
        running = false;
    }

    private void keepRunning1() {
        try {
            Object lock = new Object();
            synchronized (lock) {
                while (true) {
                    lock.wait();
                }
            }
        } catch (InterruptedException ex) {
            System.exit(1);
        }
    }

}
